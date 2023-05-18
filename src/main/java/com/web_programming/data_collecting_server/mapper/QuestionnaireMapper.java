package com.web_programming.data_collecting_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_programming.data_collecting_server.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;

import java.util.Base64;

@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
}
