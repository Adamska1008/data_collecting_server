package com.web_programming.data_collecting_server.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

// 数据过滤器
// 其用于过滤不合理的数据
// 输入值为一个数据库中的real_time_data，内容包含反序列化处理
public class Filter {
    public static boolean common(String msg) {
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

    public static boolean commonBreathing(JSONObject object) {
        int freq = object.getIntValue("呼吸频率");
        int wet = object.getIntValue("潮气量");
        int dens = object.getIntValue("氧浓度");
        return freq >= 16 && freq <= 30 && wet >= 6 && wet <= 15 && dens >= 0 && dens <= 50;
    }

    public static boolean commonOximeter(JSONObject object) {
        int bloodOxygenSaturation = object.getIntValue("血氧饱和度");
        int pulseRate = object.getIntValue("脉率");
        return bloodOxygenSaturation >= 94 && bloodOxygenSaturation <= 98 && pulseRate >= 60 && pulseRate <= 90;
    }

    public static boolean commonSpirometer(JSONObject object) {
        int flowPeak = object.getIntValue("呼气流量峰值");
        double vitalCapacity = object.getDoubleValue("用力肺活量");
        return flowPeak >= 180 && flowPeak <= 600 && vitalCapacity >= 2.730 && vitalCapacity <= 3.971;
    }

    public static boolean commonAirPurifier(JSONObject object) {
        int pm2dot5 = object.getIntValue("PM2.5");
        return pm2dot5 >= 0 && pm2dot5 <= 115;
    }

    public static boolean validHygrothermograph(JSONObject object) {
        int temperature = object.getIntValue("温度");
        return temperature >= 24 && temperature <= 26;
    }
}
