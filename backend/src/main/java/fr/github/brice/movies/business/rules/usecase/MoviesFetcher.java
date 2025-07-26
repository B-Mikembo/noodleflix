package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.List;

public class MoviesFetcher {
    private final MovieRepository movieRepository;

    public MoviesFetcher(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> fetchMovies() {
        return movieRepository.findAll();
    }
}
