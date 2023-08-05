package com.example.api;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @GetMapping(produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    List<Book> getAllBooks() {
        return List.of(
                new Book("Harry Potter", "J. K. Rowling", 1997, 233),
                new Book("The Wolf of Wall Street", "Jordan Belfort", 2004, 514)
        );
    }

    @GetMapping("/1")
    Book getSingleBook() {
        return new Book("Harry Potter", "J. K. Rowling", 1997, 233);
    }

}
