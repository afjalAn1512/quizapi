package com.quizapi.quiz.controller;

import com.quizapi.quiz.model.exam.Book;
import com.quizapi.quiz.model.exam.Category;
import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;
import com.quizapi.quiz.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    //post category
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Category category){

        Category category1 = this.categoryService.addCategory(category);

        return ResponseEntity.ok(category1);
    }

    //getCategory
    @GetMapping("/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId){
        return this.categoryService.getCategory(categoryId);
    }

    //get all question of any quid
    @GetMapping("/book/{bid}")
    public ResponseEntity<?> getBookCategory(@PathVariable("bid") Long bid){
        Book book = new Book();
        book.setBid(bid);
        Set<Category> questionOfQuiz = this.categoryService.getAllCategories(book);
        return ResponseEntity.ok(questionOfQuiz);
    }


    //get all category
    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.of(Optional.ofNullable(this.categoryService.getCategories()));
    }


    //update category
    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    //delete category

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId){
        this.categoryService.deleteCategory(categoryId);
    }

}
