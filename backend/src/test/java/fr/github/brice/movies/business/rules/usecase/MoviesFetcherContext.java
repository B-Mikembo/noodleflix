package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.stub.InMemoryMovieRepository;

import java.util.List;

import static fr.github.brice.movies.MovieFixture.*;

public class MoviesFetcherContext {
    private final InMemoryMovieRepository movies = new InMemoryMovieRepository();

    public MoviesFetcherContext() {
        populateRepositoryWithSomeMovies();
    }

    private void populateRepositoryWithSomeMovies() {
        List.of(
                theDragons(),
                theM3ganTwoDotZero(),
                theLiloAndStitch(),
                theDemonSlayer()
        ).forEach(movies::save);
    }

    public MoviesFetcher buildUseCase() {
        return new MoviesFetcher(movies);
    }

    public void withNoMovies() {
        movies.removeAll();
    }
}
