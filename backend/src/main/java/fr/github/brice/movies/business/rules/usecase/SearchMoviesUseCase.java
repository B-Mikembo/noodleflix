package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class SearchMoviesUseCase {
    private final MovieRepository movies;

    public SearchMoviesUseCase(MovieRepository movies) {
        this.movies = movies;
    }

    public List<Movie> execute(String query) {
        if (query.isEmpty()) {
            return Collections.emptyList();
        }
        return movies.search(query);
    }
}
