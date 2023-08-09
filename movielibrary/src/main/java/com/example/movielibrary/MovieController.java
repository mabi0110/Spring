package com.example.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    @Autowired
    MovieRespository movieRespository;

    @GetMapping("/test")
    public int test() {
        return 1;
    }

    @GetMapping("/movies")
    public List<Movie> getAll() {
        return  movieRespository.getAll();
    }
}
