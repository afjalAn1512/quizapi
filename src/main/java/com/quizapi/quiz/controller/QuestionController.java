package com.quizapi.quiz.controller;

import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;
import com.quizapi.quiz.service.QuestionService;
import com.quizapi.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;


    @Autowired
    private QuizService quizService;


    //add question
    @PostMapping("/")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
       return ResponseEntity.ok(this.questionService.addQuestion(question));
    }

    //update question
    @PutMapping("/")
    public ResponseEntity<Question> updateQuestion(@RequestBody Question question){
        return ResponseEntity.ok(this.questionService.updateQuestion(question));
    }

    //get all question of any quid
    @GetMapping("/quiz/{qid}")
    public ResponseEntity<?> getQuestionOfQuiz(@PathVariable("qid") Long qid){
//        Quiz quiz = new Quiz();
//        quiz.setqId(qid);
//        Set<Question> questionOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
//        return ResponseEntity.ok(questionOfQuiz);


       Optional<Quiz> quiz = this.quizService.gwtQuiz(qid);

        Set<Question> questions = quiz.get().getQuestions();

        List list = new ArrayList(questions);

        if (list.size()>Integer.parseInt(quiz.get().getNumberOfQuestions())){
            list = list.subList(0,Integer.parseInt(quiz.get().getNumberOfQuestions()));
        }
        Collections.shuffle(list);
        return ResponseEntity.ok(list);


    }

    //get single question
    @GetMapping("/{quesId}")
    public Optional<Question> get(@PathVariable("quesId") Long quesId){
        return this.questionService.getQuestion(quesId);
    }

    @DeleteMapping("/{quesId}")
    public void delete(@PathVariable("quesId") Long quesId){
        this.questionService.deleteQuestion(quesId);
    }




}
