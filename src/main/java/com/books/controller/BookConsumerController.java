package com.books.controller;

import com.books.model.Book;
import com.books.service.BookConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookConsumerController {

    @Autowired
    private BookConsumerService bookConsumerService;

    @GetMapping("/consume/books")
    public List<Book> getBooks() {
        return bookConsumerService.getBooks();
    }
}
