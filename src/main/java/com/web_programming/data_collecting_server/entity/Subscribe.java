package com.web_programming.data_collecting_server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("subscribe")
public class Subscribe {
    @TableField("client_id")
    private int clientId;
    @TableField("sensor_id")
    private int sensorId;

    public Subscribe() {
    }

    public Subscribe(int clientId, int sensorId) {
        this.clientId = clientId;
        this.sensorId = sensorId;
    }
}
