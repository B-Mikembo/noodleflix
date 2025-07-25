package fr.github.brice.movies.business.rules.entity;

import fr.github.brice.movies.business.rules.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.github.brice.movies.business.rules.MovieAssertions.assertThat;

@UnitTest
@DisplayName("Movie test")
class MovieTest {
    @Test
    void shouldReturnTitleWhenCreateMovieInstance() {
        var movie = new Movie("Dragons");

        assertThat(movie)
                .hasTitle("Dragons");
    }
}