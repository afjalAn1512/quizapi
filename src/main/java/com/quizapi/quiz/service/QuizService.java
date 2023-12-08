package com.quizapi.quiz.service;

import com.quizapi.quiz.model.exam.Quiz;

import java.util.Optional;
import java.util.Set;

public interface QuizService {

    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public Set<Quiz> getQuizzes();

    public Optional<Quiz> gwtQuiz(Long quizId);

    public void deleteQuiz(Long quizId);

}
