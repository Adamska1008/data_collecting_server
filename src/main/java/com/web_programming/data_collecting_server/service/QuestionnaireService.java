package com.web_programming.data_collecting_server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.web_programming.data_collecting_server.entity.Questionnaire;
import org.springframework.stereotype.Component;

@Component
public interface QuestionnaireService extends IService<Questionnaire> {
    int getGrade(int clientId);
}
