package com.quizapi.quiz.service;

import com.quizapi.quiz.model.exam.Book;
import com.quizapi.quiz.model.exam.Category;
import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Set<Category> getCategories();

    public Set<Category> getAllCategories(Book book);

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);




}
