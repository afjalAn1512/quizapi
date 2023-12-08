package com.quizapi.quiz.controller;

import com.quizapi.quiz.model.exam.Quiz;
import com.quizapi.quiz.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@CrossOrigin("*")
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;


    //add quiz
    @PostMapping("/")
    public ResponseEntity<Quiz> addQuiz(@RequestBody Quiz quiz){
        Quiz quiz1 = this.quizService.addQuiz(quiz);

        return ResponseEntity.ok(quiz1);
    }


    //update quiz
    @PutMapping("/")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz){
        return ResponseEntity.ok(this.quizService.updateQuiz(quiz));
    }

    //get quiz
    @GetMapping("/")
    public ResponseEntity<?> quizzes(){
        return ResponseEntity.ok(this.quizService.getQuizzes());
    }


    //get single quiz
    @GetMapping("/{qId}")
    public Optional<Quiz> quiz(@PathVariable("qId") Long qId){
        return this.quizService.gwtQuiz(qId);
    }

    //delete quiz
    @DeleteMapping("/{qId}")
    public void deleteQuiz(@PathVariable("qId") Long qId){
        this.quizService.deleteQuiz(qId);
    }



}
