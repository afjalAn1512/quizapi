package com.quizapi.quiz.repo;

import com.quizapi.quiz.model.exam.Book;
import com.quizapi.quiz.model.exam.Category;
import com.quizapi.quiz.model.exam.Question;
import com.quizapi.quiz.model.exam.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Set<Category> findByBook(Book book);
}
