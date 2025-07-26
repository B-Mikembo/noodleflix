package fr.github.brice.movies.gateway;

import java.util.List;

public class MoviesResponse {
    private int page;
    private List<MovieResponse> results;
    private int totalPages;
    private int totalResults;
}
