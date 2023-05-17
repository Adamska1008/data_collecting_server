package com.web_programming.data_collecting_server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sensor")
public class Sensor {
    @TableField("id")
    private int id;

    @TableField("type")
    private int type;
}
