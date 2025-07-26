package fr.github.brice.movies.gateway;

import fr.github.brice.movies.business.rules.entity.Movie;

import java.util.List;

public class MoviesResponse {
    private int page;
    private List<MovieResponse> results;
    private int totalPages;
    private int totalResults;

    public int page() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieResponse> results() {
        return results;
    }

    public void setResults(List<MovieResponse> results) {
        this.results = results;
    }

    public int totalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int totalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> toDomain() {
        return results.stream()
                .map(MovieResponse::toDomain)
                .toList();
    }
}
