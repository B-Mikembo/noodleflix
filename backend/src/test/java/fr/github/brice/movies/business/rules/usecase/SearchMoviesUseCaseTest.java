package fr.github.brice.movies.business.rules.usecase;

import fr.github.brice.movies.business.rules.UnitTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.github.brice.movies.MovieFixture.theDemonSlayer;
import static fr.github.brice.movies.MovieFixture.theManWithNoPast;
import static org.assertj.core.api.Assertions.assertThat;

@UnitTest
@DisplayName("Search Movies test")
public class SearchMoviesUseCaseTest {
    private SearchMoviesContext context;

    @BeforeEach
    void setup() {
        context = new SearchMoviesContext();
    }

    @Test
    void shouldReturnEmptyListWhenSearchMoviesWithEmptyQuery() {
        var searchMoviesUseCase = context.buildUseCase();

        var movies = searchMoviesUseCase.execute("");

        assertThat(movies).isEmpty();
    }

    @Test
    void shouldReturnMovieWithExactlyCorrespondingMovieTitleWhenSearchMovies() {
        var searchMoviesUseCase = context.buildUseCase();

        var movies = searchMoviesUseCase.execute("Man with No Past");

        assertThat(movies)
                .containsExactly(theManWithNoPast());
    }

    @Test
    void shouldReturnMoviesWithMovieTitleContainingQueryWhenSearchMovies() {
        var searchMoviesUseCase = context.buildUseCase();

        var movies = searchMoviesUseCase.execute("No");

        assertThat(movies)
                .containsExactly(theDemonSlayer(), theManWithNoPast());
    }
}
