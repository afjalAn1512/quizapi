package com.quizapi.quiz.service.impl;

import com.quizapi.quiz.model.exam.Quiz;
import com.quizapi.quiz.repo.QuizRepository;
import com.quizapi.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    QuizRepository quizRepository;

    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Set<Quiz> getQuizzes() {
        return new HashSet<>(this.quizRepository.findAll());
    }

    @Override
    public Optional<Quiz> gwtQuiz(Long quizId) {
        return this.quizRepository.findById(quizId);
    }

    @Override
    public void deleteQuiz(Long quizId) {
        Quiz quiz = new Quiz();

        quiz.setqId(quizId);
        this.quizRepository.delete(quiz);
    }
}
