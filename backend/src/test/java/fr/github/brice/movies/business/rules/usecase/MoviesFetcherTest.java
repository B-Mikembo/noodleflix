package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.rules.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.github.brice.movies.business.rules.MovieFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
@DisplayName("Fetch all movies test")
public class MoviesFetcherTest {

    private MoviesFetcherContext context;
    private MoviesFetcher moviesFetcher;

    @BeforeEach
    void setUp() {
        context = new MoviesFetcherContext();
        moviesFetcher = context.buildUseCase();
    }

    @Test
    void shouldReturnEmptyMoviesWhenFetchAllMovies() {
        context.withNoMovies();

        var movies = moviesFetcher.fetchMovies();

        assertThat(movies).isNotNull().isEmpty();
    }

    @Test
    void shouldReturnMoviesWhenFetchAllMovies() {

        var movies = moviesFetcher.fetchMovies();

        assertThat(movies)
                .containsExactly(
                        theDragons(),
                        theM3ganTwoDotZero(),
                        theLiloAndStitch(),
                        theAmnesique()
                );
    }
}
