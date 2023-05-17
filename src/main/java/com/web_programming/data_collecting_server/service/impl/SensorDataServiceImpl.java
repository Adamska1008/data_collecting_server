package com.web_programming.data_collecting_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_programming.data_collecting_server.entity.SensorData;
import com.web_programming.data_collecting_server.mapper.SensorDataMapper;
import com.web_programming.data_collecting_server.service.SensorDataService;

import java.util.Map;

public class SensorDataServiceImpl extends ServiceImpl<SensorDataMapper, SensorData> implements SensorDataService {
    @Override
    public Map<String, String> getData(int clientId) {

        return null;
    }
}
