package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.rules.usecase.MoviesFetcher;
import fr.github.brice.movies.business.rules.usecase.SearchMoviesUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {
    private final MoviesFetcher moviesFetcher;
    private final SearchMoviesUseCase searchMoviesUseCase;

    public MovieController(MoviesFetcher moviesFetcher, SearchMoviesUseCase searchMoviesUseCase) {
        this.moviesFetcher = moviesFetcher;
        this.searchMoviesUseCase = searchMoviesUseCase;
    }

    @GetMapping("/movies")
    ResponseEntity<MoviesResponse> getMovies() {
        var movies = moviesFetcher.fetchMovies();
        return ResponseEntity.ok(MoviesResponse.fromDomain(movies));
    }

    @GetMapping("/search/movies")
    ResponseEntity<MoviesResponse> searchMovies(@RequestParam(name = "query") String query) {
        var movies = searchMoviesUseCase.execute(query);
        return ResponseEntity.ok(MoviesResponse.fromDomain(movies));
    }
}
