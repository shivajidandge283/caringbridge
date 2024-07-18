package com.db.hackathon.dementia.dabbler.caringbridge.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long queId;
    private LocalDate quizDate;
    private Long quizId;
    private String userId;
    private Boolean correctness;

    // getters and setters
}
