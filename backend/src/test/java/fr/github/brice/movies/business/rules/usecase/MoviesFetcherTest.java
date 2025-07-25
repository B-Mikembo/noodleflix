package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.gateway.stub.InMemoryMovieRepository;
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
    private MovieRepository movieRepository;

    @BeforeEach
    void setUp() {
        movieRepository = new InMemoryMovieRepository();
        moviesFetcher = new MoviesFetcher(movieRepository);
    }

    @Test
    void shouldReturnEmptyMoviesWhenFetchAllMovies() {
        var movies = moviesFetcher.fetchMovies();

        assertThat(movies).isNotNull().isEmpty();
    }

    @Test
    void shouldReturnOneMovieWhenFetchAllMovies() {
        var theDragons = new Movie(1, "Dragons", 0.81, "https://dragons.com", "11/06/2025", "FR");
        movieRepository.save(theDragons);

        var movies = moviesFetcher.fetchMovies();

        assertThat(movies)
                .containsExactly(theDragons);
    }
}
