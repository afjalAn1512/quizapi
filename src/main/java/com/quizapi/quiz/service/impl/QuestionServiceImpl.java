package com.quizapi.quiz.service.impl;

import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;
import com.quizapi.quiz.repo.QuestionRepository;
import com.quizapi.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    @Override
    public Question addQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Question updateQuestion(Question question) {
        return this.questionRepository.save(question);
    }

    @Override
    public Set<Question> getQuestions() {
        return new HashSet<>(this.questionRepository.findAll());
    }

    @Override
    public Optional<Question> getQuestion(Long quesId) {
        return this.questionRepository.findById(quesId);
    }

    @Override
    public Set<Question> getQuestionOfQuiz(Quiz quiz) {
        return this.questionRepository.findByQuiz(quiz);
    }

    @Override
    public void deleteQuestion(Long quesId) {
        Question question = new Question();

        question.setQuesId(quesId);
        this.questionRepository.delete(question);
    }
}
