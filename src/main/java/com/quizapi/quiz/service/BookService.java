package com.quizapi.quiz.service;

import com.quizapi.quiz.model.exam.Book;

import java.util.Optional;
import java.util.Set;

public interface BookService {

    public Book addBook(Book book);

    public Book updateBook(Book book);

    public Set<Book> getBook();

    public Optional<Book> getBook(Long bookId);

    public void deleteBook(Long bookId);

}
