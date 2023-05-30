package com.web_programming.data_collecting_server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.sql.Timestamp;

@Data
@TableName("sensor_data")
public class SensorData {
    @TableField("sensor_id")
    private int sensorId;

    @TableField("acquisition_time")
    private Timestamp acquisitionTime;

    @TableField("real_time_data")
    private String realTimeData;


}
