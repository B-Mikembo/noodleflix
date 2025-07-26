package fr.github.brice.movies.business.rules.entity;

import fr.github.brice.movies.business.rules.UnitTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static fr.github.brice.movies.business.rules.MovieAssertions.assertThat;

@UnitTest
@DisplayName("Movie test")
class MovieTest {
    @Test
    void shouldReturnAllInformationWhenCreateMovieInstance() {
        var movie = new Movie(1,"Dragons", 0.81, "https://dragons.com", "11/06/2025", "FR");

        assertThat(movie)
                .hasId(1)
                .hasTitle("Dragons")
                .hasVoteAverage(0.81)
                .hasPosterPath("https://dragons.com")
                .hasReleaseDate("11/06/2025")
                .hasOriginalLanguage("FR");
    }
}