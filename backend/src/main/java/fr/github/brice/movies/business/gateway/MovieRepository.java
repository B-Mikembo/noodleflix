package fr.github.brice.movies.business.gateway;

import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.List;

public interface MovieRepository {
    List<Movie> findAll();

    List<Movie> search(String query);
}
