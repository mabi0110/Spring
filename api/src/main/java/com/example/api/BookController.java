package com.example.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookController {

    @GetMapping("/api/books")
    @ResponseBody
    List<Book> getAllBooks() {
        return List.of(
                new Book("Harry Potter", "J. K. Rowling", 1997, 233),
                new Book("The Wolf of Wall Street", "Jordan Belfort", 2004, 514)
        );
    }

    @GetMapping("/api/books/1")
    @ResponseBody
    Book getSingleBook() {
        return new Book("Harry Potter", "J. K. Rowling", 1997, 233);
    }

}
