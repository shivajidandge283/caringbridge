package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Question;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    IQuestionRepository questionRepository;

    public List<Question> getQuizQuestions(){
        return questionRepository.findAll();
    }
}
