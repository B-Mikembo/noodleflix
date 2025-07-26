package fr.github.brice.movies.controller;

import fr.github.brice.movies.gateway.TMDBClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MovieController {
    private final TMDBClient tmdbClient;

    public MovieController(TMDBClient tmdbClient) {
        this.tmdbClient = tmdbClient;
    }

    @GetMapping("/movies")
    public void findAll() {
        tmdbClient.findAll();
    }
}
