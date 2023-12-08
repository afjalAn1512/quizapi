package com.quizapi.quiz.repo;

import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Set<Question> findByQuiz(Quiz quiz);
}
