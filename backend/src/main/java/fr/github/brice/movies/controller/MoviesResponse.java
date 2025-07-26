package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.List;

public record MoviesResponse(
        List<MovieResponse> movies
) {
    public static MoviesResponse fromDomain(List<Movie> movies) {
        return new MoviesResponse(
                movies.stream()
                        .map(MovieResponse::fromDomain)
                        .toList()
        );
    }
}
