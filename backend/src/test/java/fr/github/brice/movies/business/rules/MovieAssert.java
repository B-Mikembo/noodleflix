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

    public MovieAssert hasVoteAverage(double voteAverage) {
        isNotNull();
        if (actual.voteAverage() != voteAverage) {
            failWithMessage("Expected vote average to be '%d' but was '%d'", voteAverage, actual.voteAverage());
        }
        return this;
    }

    public MovieAssert hasPosterPath(String posterPath) {
        isNotNull();
        if (!actual.posterPath().equals(posterPath)) {
            failWithMessage("Expected poster path to be '%s' but was '%s'", posterPath, actual.posterPath());
        }
        return this;
    }

    public MovieAssert hasReleaseDate(String releaseDate) {
        isNotNull();
        if (!actual.releaseDate().equals(releaseDate)) {
            failWithMessage("Expected release date to be '%s' but was '%s'", releaseDate, actual.releaseDate());
        }
        return this;
    }

    public MovieAssert hasOriginalLanguage(String originalLanguage) {
        isNotNull();
        if (!actual.originalLanguage().equals(originalLanguage)) {
            failWithMessage("Expected original language to be '%s' but was '%s'", originalLanguage, actual.originalLanguage());
        }
        return this;
    }

    public MovieAssert hasId(int id) {
        isNotNull();
        if (actual.id() != id) {
            failWithMessage("Expected id to be '%d' but was '%d'", id, actual.id());
        }
        return this;
    }
}
