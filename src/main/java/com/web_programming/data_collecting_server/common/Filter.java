package com.web_programming.data_collecting_server.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

// 数据过滤器
// 其用于过滤不合理的数据
// 输入值为一个数据库中的real_time_data，内容包含反序列化处理
public class Filter {
    public boolean common(String msg) {
        var object = JSON.parseObject(msg);
        var id = object.getString("id");
        if (id.startsWith("呼吸机")) {
            return commonBreathing(object);
        } else if (id.startsWith("血氧仪")) {
            return commonOximeter(object);
        } else if (id.startsWith("肺功能仪")){
            return commonSpirometer(object);
        } else if (id.startsWith("空气净化器")){
            return commonAirPurifier(object);
        } else if (id.startsWith("温湿度计")) {
            return validHygrothermograph(object);
        } else {
            return false;
        }
    }

    public boolean commonBreathing(JSONObject object) {
        int freq = object.getIntValue("呼吸频率");
        int wet = object.getIntValue("潮气量");
        int dens = object.getIntValue("氧浓度");
        return freq >= 16 && freq <= 30 && wet >= 6 && wet <= 15 && dens >= 0 && dens <= 50;
    }

    public boolean commonOximeter(JSONObject object) {
        return true;
    }

    public boolean commonSpirometer(JSONObject object) {
        return true;
    }

    public boolean commonAirPurifier(JSONObject object) {
        return true;
    }

    public boolean validHygrothermograph(JSONObject object) {
        return true;
    }

}
