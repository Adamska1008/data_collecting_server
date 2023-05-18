package com.web_programming.data_collecting_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_programming.data_collecting_server.entity.SensorData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensorDataMapper extends BaseMapper<SensorData> {
}
