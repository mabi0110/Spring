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

    @PutMapping("/{id}")
    public int update(@PathVariable int id, @RequestBody Movie updatedMovie){
        Movie movie = movieRespository.getById(id);
        if (movie != null) {
            movie.setTitle(updatedMovie.getTitle());
            movie.setRating(updatedMovie.getRating());
            movieRespository.update(movie);
            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable int id, @RequestBody Movie updatedMovie){
        Movie movie = movieRespository.getById(id);
        if (movie != null) {
            if (updatedMovie.getTitle() != null) {
                movie.setTitle(updatedMovie.getTitle());
            }
            if (updatedMovie.getRating() > 0) {
                movie.setRating((updatedMovie.getRating()));
            }
            movieRespository.update(movie);
            return 1;
        } else {
            return -1;
        }

    }


}
