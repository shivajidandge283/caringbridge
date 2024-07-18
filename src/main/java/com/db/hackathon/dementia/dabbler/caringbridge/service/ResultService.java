package com.db.hackathon.dementia.dabbler.caringbridge.service;

import com.db.hackathon.dementia.dabbler.caringbridge.dto.ResultResponse;
import com.db.hackathon.dementia.dabbler.caringbridge.entity.Question;
import com.db.hackathon.dementia.dabbler.caringbridge.entity.Result;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IQuestionRepository;
import com.db.hackathon.dementia.dabbler.caringbridge.repository.IResultRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ResultService {

    @Autowired
    private IResultRepository IResultRepository;

    @Autowired
    private IQuestionRepository questionRepository;


    public List<ResultResponse> getAnswersWithDetails() {
        List<Result> results = IResultRepository.findAll();

        return results.stream().map(result -> {
            Question question = questionRepository.findById(result.getQueId()).orElse(null);

            if (question != null ) {
                ResultResponse response = new ResultResponse();
                response.setQuizId(result.getQuizId());
                response.setQuestionId(result.getQueId());
                response.setUserId(result.getId()); // Assuming userId is the same as answerId
                response.setCorrectness(question.getAnswer().equals("some user's answer")); // Adjust as needed
                response.setQuizDate(result.getQuizDate());
                response.setCategory(question.getQueCategory());
                return response;
            }

            return null;
        }).collect(Collectors.toList());
    }

    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Transactional
    public void submitAnswers(Map<Long, Boolean> answersMap, String userId) {
        LocalDate currentDate = LocalDate.now();
        Long maxQuizId = IResultRepository.findMaxQuizIdByDate(currentDate);
        Long newQuizId = maxQuizId + 1;

        for (Map.Entry<Long, Boolean> entry : answersMap.entrySet()) {
            Long queId = entry.getKey();
            Boolean correctness = entry.getValue();

            Result result = new Result();
            result.setQuizId(newQuizId);
            result.setQueId(queId);
            result.setCorrectness(correctness);
            result.setUserId(userId);
            result.setQuizDate(currentDate);

            IResultRepository.save(result);
        }
    }
}
