package fr.github.brice.movies.business.gateway;

import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.List;

public interface MovieRepository {
    Movie save(Movie movie);

    List<Movie> findAll();
}
