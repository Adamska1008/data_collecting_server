package com.web_programming.data_collecting_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_programming.data_collecting_server.entity.SensorData;

import java.util.List;

public interface SensorDataService extends IService<SensorData> {
    List<Object> getData(int groupId);
}
