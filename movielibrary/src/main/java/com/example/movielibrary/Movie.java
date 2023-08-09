package com.example.movielibrary;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private int id;
    private String title;
    private int rating;
}
