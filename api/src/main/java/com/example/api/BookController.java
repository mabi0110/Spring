package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @GetMapping("/api/books")
    List<Book> getAllBooks() {
        return List.of(
                new Book("Harry Potter", "J. K. Rowling", 1997, 233),
                new Book("The Wolf of Wall Street", "Jordan Belfort", 2004, 514)
        );
    }

    @GetMapping("/api/books/1")
    Book getSingleBook() {
        return new Book("Harry Potter", "J. K. Rowling", 1997, 233);
    }

}
