package com.quizapi.quiz.repo;

import com.quizapi.quiz.model.exam.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
