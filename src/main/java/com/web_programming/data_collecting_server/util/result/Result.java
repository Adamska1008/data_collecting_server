package com.web_programming.data_collecting_server.util.result;

import lombok.Data;

import java.util.Date;
import java.util.Map;

@Data
public class Result {
    //id
    private Integer id;

    //time
    private Date time;

    //返回数据
    private Map<String, Float> data;

    // 是否正常
    private boolean situation;

    public Result(){}

    public Result(Integer id, Date time, Map<String, Float> data, boolean situation) {
        this.id = id;
        this.time = time;
        this.data = data;
        this.situation = situation;
    }

}
