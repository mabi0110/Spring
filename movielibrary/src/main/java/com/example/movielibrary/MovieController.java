package com.example.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieRespository movieRespository;

    @GetMapping
    public List<Movie> getAll() {
        return  movieRespository.getAll();
    }

    @GetMapping("/{id}")
    public Movie getById(@PathVariable int id){
        return movieRespository.getById(id);
    }

    @PostMapping
    public int add(@RequestBody List<Movie> movies) {
        return movieRespository.save(movies);
    }

}
