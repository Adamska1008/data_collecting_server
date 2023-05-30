package com.web_programming.data_collecting_server.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.web_programming.data_collecting_server.common.Filter;
import com.web_programming.data_collecting_server.entity.SensorData;
import com.web_programming.data_collecting_server.mapper.SensorDataMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.*;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Time;
import java.sql.Timestamp;

@Slf4j
@Component
public class BootNettyMqttChannelInboundHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    SensorDataMapper sensorDataMapper;
    /*
    从客户端接受新数据时会调用这个方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception, IOException {
        if (msg != null) {
            MqttMessage message = (MqttMessage) msg;
            log.debug("receive mqtt message: " + message);
            MqttFixedHeader header = message.fixedHeader();
            Channel channel = ctx.channel();
            switch (header.messageType()) {
                case CONNECT -> con_ack(channel, message);
                case PUBLISH -> publish_ack(channel, message);
            }
        }
    }

    public void con_ack(Channel channel, MqttMessage message) {
        var connectMessage = (MqttConnectMessage) message;
        var mqttFixedHeader = connectMessage.fixedHeader();
        var mqttConnectVariableHeader = connectMessage.variableHeader();
        var mqttConnAckVariableHeaderBack = new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, mqttConnectVariableHeader.isCleanSession());
        var mqttFixedHeaderBack = new MqttFixedHeader(MqttMessageType.CONNACK, mqttFixedHeader.isDup(), MqttQoS.AT_MOST_ONCE, mqttFixedHeader.isRetain(), 0x02);
        var connAck = new MqttConnAckMessage(mqttFixedHeaderBack, mqttConnAckVariableHeaderBack);
        log.debug("connection ack, back: " + connAck);
        channel.writeAndFlush(connAck);
    }

    public void publish_ack(Channel channel, MqttMessage message) {
        // 像数据库中存储数据
        var mqttPublishMessage = (MqttPublishMessage) message;
        String payload = mqttPublishMessage.payload().toString(CharsetUtil.UTF_8);
        log.info("publish data--" + payload);
        var filter = new Filter();
        // 若消息不合法则直接不处理
        if (!filter.common(payload)) {
            return;
        }
        var mqttFixedHeader = mqttPublishMessage.fixedHeader();
        var qos = (MqttQoS) mqttFixedHeader.qosLevel();
        var id = extractId(payload);
        var time = extractTime(payload);
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(id);
        sensorData.setAcquisitionTime(time);
        sensorData.setRealTimeData(payload);
        sensorDataMapper.insert(sensorData);
        switch (qos) {
            case AT_LEAST_ONCE -> {
                var mqttMessageIdVariableHeaderBack = MqttMessageIdVariableHeader.from(mqttPublishMessage.variableHeader().packetId());
                //	构建返回报文， 固定报头
                var mqttFixedHeaderBack = new MqttFixedHeader(MqttMessageType.PUBACK,mqttFixedHeader.isDup(), MqttQoS.AT_MOST_ONCE, mqttFixedHeader.isRetain(), 0x02);
                //	构建PUBACK消息体
                var pubAck = new MqttPubAckMessage(mqttFixedHeaderBack, mqttMessageIdVariableHeaderBack);
                log.info("back--"+pubAck);
                channel.writeAndFlush(pubAck);
            }
            case EXACTLY_ONCE -> {
                //	构建返回报文， 固定报头
                var mqttFixedHeaderBack = new MqttFixedHeader(MqttMessageType.PUBREC,false, MqttQoS.AT_LEAST_ONCE,false,0x02);
                //	构建返回报文， 可变报头
                var mqttMessageIdVariableHeaderBack = MqttMessageIdVariableHeader.from(mqttPublishMessage.variableHeader().packetId());
                var mqttMessageBack = new MqttMessage(mqttFixedHeaderBack,mqttMessageIdVariableHeaderBack);
                log.info("back--"+mqttMessageBack);
                channel.writeAndFlush(mqttMessageBack);
            }
        }
    }

    private int extractId(String payload) {
        var object = JSONObject.parseObject(payload);
        var id = object.getString("id");
        var dotPos = id.indexOf('.');
        var number = id.substring(dotPos);
        return Integer.parseInt(number);
    }

    private Timestamp extractTime(String payload) {
        var object = JSONObject.parseObject(payload);
        return object.getTimestamp("time");
    }
}
