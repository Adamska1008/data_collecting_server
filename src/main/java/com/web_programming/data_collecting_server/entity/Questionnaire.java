package com.web_programming.data_collecting_server.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("questionnaire")
public class Questionnaire {
    String name;
    String gender;
    String height;
    String weight;
    String age;
    String Mood;
    String diet;
    String illness;
    String sleep;

    public Questionnaire(String name, String gender, String height, String weight, String age, String mood, String diet, String illness, String sleep) {
        this.name = name;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        Mood = mood;
        this.diet = diet;
        this.illness = illness;
        this.sleep = sleep;
    }
}
