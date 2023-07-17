package com.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(LibraryApplication.class, args);
        BookRepository bookRepository = context.getBean(BookRepository.class);
        Book book1 = new Book("W pustyni i w puszczy", "Henryk Sienkiewicz", "WSIP",
                2000, 300);
        bookRepository.save(book1);
    }

}
