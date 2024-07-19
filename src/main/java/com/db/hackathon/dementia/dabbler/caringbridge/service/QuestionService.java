package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Question;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    IQuestionRepository questionRepository;

    public List<Question> getQuizQuestions(String user_id){
        List<Question> questionsWithUserId = questionRepository.findRandomQuestionsWithUserId(user_id);
        List<Question> questionsWithoutUserId = questionRepository.findRandomQuestionsWithoutUserId();

        List<Question> combinedQuestions = new ArrayList<>();

        combinedQuestions.addAll(questionsWithUserId);
        combinedQuestions.addAll(questionsWithoutUserId);

        // Shuffle combined questions to ensure random order
        Collections.shuffle(combinedQuestions);

        return combinedQuestions;
    }
}
