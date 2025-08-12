package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SearchMoviesUseCase {
    private final MovieRepository movieRepository;

    public SearchMoviesUseCase(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> execute(String query) {
        if (query.isEmpty()) {
            return Collections.emptyList();
        }
        return movieRepository.search(query);
    }
}
