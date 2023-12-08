package com.quizapi.quiz.controller;

import com.quizapi.quiz.model.exam.Book;
import com.quizapi.quiz.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    BookService bookService;

    //post book
    @PostMapping("/")
    public ResponseEntity<?> addCategory(@RequestBody Book book){

        Book book1 = this.bookService.addBook(book);

        return ResponseEntity.ok(book1);
    }


    //get single book
    @GetMapping("/{bid}")
    public Optional<Book> getBook(@PathVariable("bid") Long bid){
        return this.bookService.getBook(bid);
    }


    //get All book
    @GetMapping("/")
    public ResponseEntity<?> getBook(){
        return ResponseEntity.of(Optional.ofNullable(this.bookService.getBook()));
    }

    //update category
    @PutMapping("/")
    public Book updateBook(@RequestBody Book book){
        return this.bookService.updateBook(book);
    }

    //delete category

    @DeleteMapping("/{bid}")
    public void deleteBook(@PathVariable("bid") Long bid){
        this.bookService.deleteBook(bid);
    }


}
