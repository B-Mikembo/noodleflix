package fr.github.brice.movies.gateway;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.entity.Movie;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.lang.String.format;

@Component
public class TMDBClient implements MovieRepository {
    private final WebClient webClient;
    private final TMDBClientProperties properties;

    public TMDBClient(WebClient webClient, TMDBClientProperties properties) {
        this.webClient = webClient;
        this.properties = properties;
    }

    @Override
    public List<Movie> findAll() {
        var baseUrl = properties.baseUrl();
        var apiToken = properties.apiToken();

        var moviesResponse = webClient.get()
                .uri(baseUrl + "/discover/movie?sort_by=popularity.desc")
                .header(HttpHeaders.AUTHORIZATION, format("Bearer %s", apiToken))
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(TMDBMoviesResponse.class)
                .blockOptional()
                .orElseThrow(IllegalStateException::new);
        return moviesResponse.toDomain();
    }

    @Override
    public List<Movie> search(String query) {
        var encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String uri = properties.baseUrl() + "/search/movie?query=" + encodedQuery;
        return webClient.get()
                .uri(uri)
                .header(HttpHeaders.AUTHORIZATION, format("Bearer %s", properties.apiToken()))
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToMono(TMDBMoviesResponse.class)
                .blockOptional()
                .orElseThrow(IllegalStateException::new)
                .toDomain();
    }
}
