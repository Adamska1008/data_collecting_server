package com.web_programming.data_collecting_server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.web_programming.data_collecting_server.entity.Questionnaire;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface QuestionnaireMapper extends BaseMapper<Questionnaire> {
}
