package com.web_programming.data_collecting_server.mqtt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.mqtt.MqttFixedHeader;
import io.netty.handler.codec.mqtt.MqttMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class BootNettyMqttChannelInboundHandler extends ChannelInboundHandlerAdapter {
    /*
    从客户端接受新数据时调用这个方法
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception, IOException {
        if (msg != null) {
            MqttMessage message = (MqttMessage) msg;
            log.debug("receive mqtt message: " + message);
            MqttFixedHeader header = message.fixedHeader();
            Channel channel = ctx.channel();
            switch (header.messageType()) {
                case PUBLISH -> {
                    readPublish(message);

                }
            }
        }
    }

    public void readPublish(MqttMessage message) {
        JSONObject payload = (JSONObject) message.payload();
        int SaO2 = payload.getIntValue("SaO2");
        int PR = payload.getIntValue("PR");

    }
}
