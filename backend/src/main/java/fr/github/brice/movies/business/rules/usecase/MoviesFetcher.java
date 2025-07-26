package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MoviesFetcher {
    private final MovieRepository movieRepository;

    public MoviesFetcher(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> fetchMovies() {
        return movieRepository.findAll();
    }
}
