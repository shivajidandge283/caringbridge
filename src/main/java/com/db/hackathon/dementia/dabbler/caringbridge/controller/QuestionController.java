package com.db.hackathon.dementia.dabbler.caringbridge.controller;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Question;
import com.db.hackathon.dementia.dabbler.caringbridge.service.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping
    public List<Question> getQuizQuestions(){
        return questionService.getQuizQuestions();
    }

    @PostMapping("/attempts/{attemptId}")
    public void submitAnswers(@RequestBody Map<String,String> answersMap,@PathVariable Long attemptId){
        System.out.println(answersMap);
        System.out.println(attemptId);
    }

}
