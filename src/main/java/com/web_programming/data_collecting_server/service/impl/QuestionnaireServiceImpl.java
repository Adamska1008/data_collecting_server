package com.web_programming.data_collecting_server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.web_programming.data_collecting_server.entity.Questionnaire;
import com.web_programming.data_collecting_server.mapper.QuestionnaireMapper;
import com.web_programming.data_collecting_server.service.QuestionnaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionnaireServiceImpl extends ServiceImpl<QuestionnaireMapper, Questionnaire> implements QuestionnaireService {
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Override
    public int getGrade(int clientId) {
        return 0;
    }
}
