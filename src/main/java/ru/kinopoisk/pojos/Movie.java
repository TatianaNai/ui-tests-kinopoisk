package ru.kinopoisk.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    private String name;
    private int releaseYear;
    private double rating;
}
