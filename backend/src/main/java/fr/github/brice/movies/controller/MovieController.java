package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.rules.usecase.MoviesFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {
    private final MoviesFetcher moviesFetcher;

    public MovieController(MoviesFetcher moviesFetcher) {
        this.moviesFetcher = moviesFetcher;
    }

    @GetMapping("/movies")
    ResponseEntity<MoviesResponse> getMovies() {
        var movies = moviesFetcher.fetchMovies();
        return ResponseEntity.ok(MoviesResponse.fromDomain(movies));
    }
}
