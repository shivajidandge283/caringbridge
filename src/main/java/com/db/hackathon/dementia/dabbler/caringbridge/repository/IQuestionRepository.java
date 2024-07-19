package com.db.hackathon.dementia.dabbler.caringbridge.repository;

import com.db.hackathon.dementia.dabbler.caringbridge.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IQuestionRepository extends JpaRepository<Question,Long> {
    @Query(value = "SELECT * FROM question ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestions();

    @Query(value = "SELECT * FROM question WHERE user_Id = ?1 ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestionsWithUserId(String userId);

    @Query(value = "SELECT * FROM question WHERE user_id IS NULL ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestionsWithoutUserId();

}
