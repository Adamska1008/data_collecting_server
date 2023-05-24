package com.web_programming.data_collecting_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_programming.data_collecting_server.entity.SensorData;
import com.web_programming.data_collecting_server.mapper.SensorDataMapper;
import com.web_programming.data_collecting_server.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SensorDataServiceImpl extends ServiceImpl<SensorDataMapper, SensorData> implements SensorDataService {
    @Autowired
    SensorDataMapper sensorDataMapper;
    @Override
    public Map<String, String> getData(int clientId) {

        return null;
    }
}
