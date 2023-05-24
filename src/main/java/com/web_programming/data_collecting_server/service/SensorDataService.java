package com.web_programming.data_collecting_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_programming.data_collecting_server.entity.SensorData;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface SensorDataService extends IService<SensorData> {
    Map<String, String> getData(int clientId);
}
