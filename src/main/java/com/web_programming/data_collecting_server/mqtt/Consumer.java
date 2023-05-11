package com.web_programming.data_collecting_server.mqtt;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Slf4j
@RocketMQMessageListener(topic = "${rocketmq.consumer.topic}", consumerGroup = "${rocketmq.consumer.group}")
@Component
public class Consumer implements RocketMQListener<String> {
    @Override
    public void onMessage(String o) {
        System.out.println("Consumer onMessage: " + o);
        log.debug("Consumer onMessage: " + o);
    }
}
