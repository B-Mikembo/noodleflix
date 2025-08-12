package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.stub.InMemoryMovieRepository;

import java.util.List;

import static fr.github.brice.movies.MovieFixture.*;

public class SearchMoviesContext {
    private final InMemoryMovieRepository movies = new InMemoryMovieRepository();

    public SearchMoviesContext() {
        populateRepositoryWithSomeMovies();
    }

    private void populateRepositoryWithSomeMovies() {
        List.of(
                theDragons(),
                theM3ganTwoDotZero(),
                theLiloAndStitch(),
                theDemonSlayer(),
                theManWithNoPast()
        ).forEach(movies::save);
    }

    public SearchMoviesUseCase buildUseCase() {
        return new SearchMoviesUseCase(movies);
    }
}
