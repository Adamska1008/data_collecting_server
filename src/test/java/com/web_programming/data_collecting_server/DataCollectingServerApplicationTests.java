package com.web_programming.data_collecting_server;

import com.web_programming.data_collecting_server.service.SensorDataService;
import com.web_programming.data_collecting_server.service.impl.SensorDataServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataCollectingServerApplicationTests {

    @Autowired
    SensorDataServiceImpl sensorDataServiceImpl;
    @Test
    void contextLoads() {
    }

    @Test
    void testGetSensorData() {

    }
}
