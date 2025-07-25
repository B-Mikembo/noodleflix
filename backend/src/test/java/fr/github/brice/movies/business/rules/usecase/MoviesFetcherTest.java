package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.rules.UnitTest;
import fr.github.brice.movies.business.rules.entity.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
@DisplayName("Fetch all movies test")
public class MoviesFetcherTest {
    private MoviesFetcher moviesFetcher;

    @BeforeEach
    void setUp() {
        moviesFetcher = new MoviesFetcher();
    }

    @Test
    void shouldReturnEmptyMoviesWhenFetchAllMovies() {
        var movies = moviesFetcher.fetchMovies();

        assertThat(movies).isNotNull().isEmpty();
    }
}
