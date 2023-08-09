package com.example.movielibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieRespository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Movie> getAll() {
        return jdbcTemplate.query("select id, title, rating from movie",
                BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Movie getById(int id) {
        return jdbcTemplate.queryForObject("select id, title, rating from movie where id = ?",
                BeanPropertyRowMapper.newInstance(Movie.class), id);
    }

    public int save(List<Movie> movies) {
        for (Movie movie : movies) {
            jdbcTemplate.update("insert into movie(title, rating) values (?, ?)",
                    movie.getTitle(), movie.getRating());
        }
        return 1;
    }

    public int update(Movie movie) {
        return jdbcTemplate.update("update movie set title=?, rating=? where id=?",
                movie.getTitle(), movie.getRating(), movie.getId());
    }

    public int delete(int id){
        return jdbcTemplate.update("delete from movie where id=?", id);
    }
}
