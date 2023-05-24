package com.web_programming.data_collecting_server.controller;


import com.web_programming.data_collecting_server.entity.Questionnaire;
import com.web_programming.data_collecting_server.service.QuestionnaireService;
import com.web_programming.data_collecting_server.service.SensorDataService;
import com.web_programming.data_collecting_server.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/client")
public class clientController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @Autowired
    private SensorDataService sensorDataService;

    @PostMapping("questionnaire")
    public Result postQuestionnaire(@RequestBody Questionnaire questionnaire) {
        if (questionnaireService.save(questionnaire)){
            return Result.ok();
        }
        return Result.fail();
    }

    @GetMapping("data/{clientId}")
    public Result getSensorData(@PathVariable int clientId) {
        Map<String,String> res= sensorDataService.getData(clientId);
        return Result.ok(res);
    }

    @GetMapping("grade/{clientId}")
    public Result getQuestionnaireGrade(@PathVariable int clientId) {
        int grade = questionnaireService.getGrade(clientId);
        return Result.ok(grade);
    }



}
