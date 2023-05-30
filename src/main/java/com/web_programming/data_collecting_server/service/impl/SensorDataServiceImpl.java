package com.web_programming.data_collecting_server.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_programming.data_collecting_server.common.Filter;
import com.web_programming.data_collecting_server.entity.SensorData;
import com.web_programming.data_collecting_server.mapper.SensorDataMapper;
import com.web_programming.data_collecting_server.mapper.SensorMapper;
import com.web_programming.data_collecting_server.mapper.SubscribeMapper;
import com.web_programming.data_collecting_server.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorDataServiceImpl extends ServiceImpl<SensorDataMapper, SensorData> implements SensorDataService {
    @Autowired
    SensorDataMapper sensorDataMapper;

    @Autowired
    SubscribeMapper subscribeMapper;

    @Autowired
    SensorMapper sensorMapper;

    @Override
    public List<Object> getData(int groupId) {
        List<Object> res = new ArrayList<>();
        res.add(getAirPurifierData(groupId));
        res.add(getOximeterData(groupId));
        res.add(getSpirometerData(groupId));
        res.add(getHygrothermoGraphData(groupId));
        res.add(getBreathingData(groupId));
        return res;
    }

    public Object getBreathingData(int groupId) {
        QueryWrapper<SensorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sensor_id", groupId)
                .orderByDesc("acquisition_time")
                .like("real_time_data", "呼吸机")
                .select("real_time_data");
        SensorData sensorData = sensorDataMapper.selectOne(queryWrapper);
        if (sensorData == null) return null;
        var data = JSON.parseObject(sensorData.getRealTimeData());
        data.put("isHealth", Filter.common(sensorData.getRealTimeData()));
        return data;
    }

    public Object getAirPurifierData(int groupId) {
        QueryWrapper<SensorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sensor_id", groupId)
                .orderByDesc("acquisition_time").last("limit 1")
                .like("real_time_data", "空气净化器")
                .select("real_time_data");
        SensorData sensorData = sensorDataMapper.selectOne(queryWrapper);
        if (sensorData == null) return null;
        var data = JSON.parseObject(sensorData.getRealTimeData());
        data.put("isHealth", Filter.common(sensorData.getRealTimeData()));
        return data;
    }

    public Object getOximeterData(int groupId) {
        QueryWrapper<SensorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sensor_id", groupId)
                .orderByDesc("acquisition_time").last("limit 1")
                .like("real_time_data", "血氧仪")
                .select("real_time_data");
        SensorData sensorData = sensorDataMapper.selectOne(queryWrapper);
        if (sensorData == null) return null;
        var data = JSON.parseObject(sensorData.getRealTimeData());
        data.put("isHealth", Filter.common(sensorData.getRealTimeData()));
        return data;
    }

    public Object getSpirometerData(int groupId) {
        QueryWrapper<SensorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sensor_id", groupId)
                .orderByDesc("acquisition_time").last("limit 1")
                .like("real_time_data", "肺功能仪")
                .select("real_time_data");
        SensorData sensorData = sensorDataMapper.selectOne(queryWrapper);
        if (sensorData == null) return null;
        var data = JSON.parseObject(sensorData.getRealTimeData());
        data.put("isHealth", Filter.common(sensorData.getRealTimeData()));
        return data;
    }

    public Object getHygrothermoGraphData(int groupId) {
        QueryWrapper<SensorData> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sensor_id", groupId)
                .orderByDesc("acquisition_time").last("limit 1")
                .like("real_time_data", "温湿度计")
                .select("real_time_data");
        SensorData sensorData = sensorDataMapper.selectOne(queryWrapper);
        if (sensorData == null) return null;
        var data = JSON.parseObject(sensorData.getRealTimeData());
        data.put("isHealth", Filter.common(sensorData.getRealTimeData()));
        return data;
    }

}
