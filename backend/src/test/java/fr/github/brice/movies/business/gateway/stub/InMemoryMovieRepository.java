package fr.github.brice.movies.business.gateway.stub;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.HashMap;
import java.util.List;

public class InMemoryMovieRepository implements MovieRepository {

    private final HashMap<Long, Movie> entities = new HashMap<>();

    @Override
    public void save(Movie movie) {
        entities.put(movie.id(), movie);
    }

    @Override
    public List<Movie> findAll() {
        return entities.values().stream().toList();
    }

    public void removeAll() {
        entities.clear();
    }
}
