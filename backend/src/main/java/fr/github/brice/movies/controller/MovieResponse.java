package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.rules.entity.Movie;

public record MovieResponse(
        String title,
        double voteAverage,
        String posterPath,
        String releaseDate,
        String originalLanguage
) {
    public static MovieResponse fromDomain(Movie movie) {
        return new MovieResponse(
                movie.title(),
                movie.voteAverage(),
                movie.posterPath(),
                movie.releaseDate(),
                movie.originalLanguage()
        );
    }
}
