package com.quizapi.quiz.service;

import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;

import java.util.Optional;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public Set<Question> getQuestions();

    public Optional<Question> getQuestion(Long quesId);

    public Set<Question> getQuestionOfQuiz(Quiz quiz);


    public void deleteQuestion(Long quesId);


}
