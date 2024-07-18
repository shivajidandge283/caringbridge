package com.db.hackathon.dementia.dabbler.caringbridge.dto;



import lombok.Data;

import java.time.LocalDate;

@Data
public class ResultResponse {
    private Long quizId;
    private Long questionId;
    private Long userId;
    private Boolean correctness;
    private LocalDate quizDate;
    private String category;

    // getters and setters
}


