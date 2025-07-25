package fr.github.brice.movies.business.rules;

import fr.github.brice.movies.business.rules.entity.Movie;
import org.assertj.core.api.Assertions;

public class MovieAssertions extends Assertions {
    public static MovieAssert assertThat(Movie movie) {
        return new MovieAssert(movie);
    }
}
