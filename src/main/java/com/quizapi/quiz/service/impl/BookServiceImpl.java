package com.quizapi.quiz.service.impl;

import com.quizapi.quiz.exception.BookNotFoundException;
import com.quizapi.quiz.model.exam.Book;
import com.quizapi.quiz.repo.BookRepository;
import com.quizapi.quiz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {

        return this.bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book) {

        return this.bookRepository.save(book);
    }

    @Override
    public Set<Book> getBook() {
        return new LinkedHashSet<>(this.bookRepository.findAll());
    }

    @Override
    public Optional<Book> getBook(Long bookId) {
        if (bookRepository.findById(bookId).isEmpty())
            throw new BookNotFoundException("Requested book does not exists... !");
        return this.bookRepository.findById(bookId);
    }

    @Override
    public void deleteBook(Long bookId) {

        Book book = new Book();
        book.setBid(bookId);
        this.bookRepository.delete(book);

    }


}
