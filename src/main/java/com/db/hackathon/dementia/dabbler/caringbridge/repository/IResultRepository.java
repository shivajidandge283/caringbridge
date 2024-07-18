package com.db.hackathon.dementia.dabbler.caringbridge.repository;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByQuizId(Long quizId);

    @Query("SELECT COALESCE(MAX(a.quizId), 0) FROM Result a WHERE a.quizDate = :quizDate")
    Long findMaxQuizIdByDate(@Param("quizDate") LocalDate quizDate);

}
