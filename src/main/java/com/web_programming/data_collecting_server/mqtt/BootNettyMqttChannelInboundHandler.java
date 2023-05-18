package com.web_programming.data_collecting_server.mqtt;

import com.alibaba.fastjson.JSONObject;
import com.web_programming.data_collecting_server.entity.SensorData;
import com.web_programming.data_collecting_server.mapper.QuestionnaireMapper;
import com.web_programming.data_collecting_server.mapper.SensorDataMapper;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Date;

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
        JSONObject payload = (JSONObject) message.payload();
        log.debug("read publish message, payload: " + payload);
        SensorData sensorData = new SensorData();
        sensorData.setSensorId(payload.getIntValue("sensor_id"));
        sensorData.setAcquisitionTime(payload.getSqlDate("acquisition_time"));
        sensorData.setRealTimeData(payload.getString("read_time_data"));
        sensorDataMapper.insert(sensorData);

        var mqttPublishMessage = (MqttPublishMessage) message;
        var mqttFixedHeader = mqttPublishMessage.fixedHeader();
        var qos = (MqttQoS) mqttFixedHeader.qosLevel();
        var headBytes = new byte[mqttPublishMessage.payload().readableBytes()];
        mqttPublishMessage.payload().readBytes(headBytes);
        var data = new String(headBytes);
        switch (qos) {
            case AT_LEAST_ONCE -> {

            }
            case EXACTLY_ONCE -> {

            }
        }
    }
}
