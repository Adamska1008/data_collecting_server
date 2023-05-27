package com.web_programming.data_collecting_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_programming.data_collecting_server.entity.Sensor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SensorMapper extends BaseMapper<Sensor> {
}
