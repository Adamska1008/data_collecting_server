package com.web_programming.data_collecting_server.mqtt;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class RocketmqApplicationTests {
    @Value("${rocketmq.consumer.topic}")
    private String topic;
    @Autowired
    Producer producer;
    @Autowired(required = false)
    private RocketMQTemplate rocketMQTemplate;
    @Test
    public void testProducer() {
        String msg = UUID.randomUUID().toString();

    }
}
