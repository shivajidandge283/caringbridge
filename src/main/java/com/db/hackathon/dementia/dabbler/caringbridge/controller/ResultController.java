package com.db.hackathon.dementia.dabbler.caringbridge.controller;

import com.db.hackathon.dementia.dabbler.caringbridge.dto.ResultResponse;
import com.db.hackathon.dementia.dabbler.caringbridge.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/result")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public List<ResultResponse> getAnswers() {
        return resultService.getAnswersWithDetails();
    }

    @PostMapping("/submit")
    public void submitAnswers(@RequestBody Map<Long,Boolean> answersMap, @RequestParam String userId){
        resultService.submitAnswers(answersMap, userId);

    }
}
