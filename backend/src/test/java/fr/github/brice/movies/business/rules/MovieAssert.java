package fr.github.brice.movies.business.rules;

import fr.github.brice.movies.business.rules.entity.Movie;
import org.assertj.core.api.AbstractAssert;

public class MovieAssert extends AbstractAssert<MovieAssert, Movie> {
    public MovieAssert(Movie movie) {
        super(movie, MovieAssert.class);
    }

    public MovieAssert hasTitle(String title) {
        isNotNull();
        if (!actual.title().equals(title)) {
            failWithMessage("Expected title to be '%s' but was '%s'", title, actual.title());
        }
        return this;
    }
}
