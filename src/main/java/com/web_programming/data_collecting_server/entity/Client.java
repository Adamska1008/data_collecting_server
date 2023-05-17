package com.web_programming.data_collecting_server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("client")
public class Client {
    @TableField("client_id")
    private int clientId;

    @TableField("client_name")
    private String client_name;
}
