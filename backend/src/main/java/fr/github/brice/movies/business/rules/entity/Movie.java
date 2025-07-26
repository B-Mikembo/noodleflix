package fr.github.brice.movies.business.rules.entity;

public record Movie(
        long id,
        String title,
        double voteAverage,
        String posterPath,
        String releaseDate,
        String originalLanguage) {
}
