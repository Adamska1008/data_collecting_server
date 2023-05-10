package com.web_programming.data_collecting_server.mqtt;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Autowired(required = false)
    private RocketMQTemplate rocketMQTemplate;

    private void sendMessage(String topic, String msg) {
        rocketMQTemplate.convertAndSend(topic, msg);
    }
}
