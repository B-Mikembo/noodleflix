package fr.github.brice.movies.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "tmdb-api")
public record TMDBClientProperties(String baseUrl, String apiToken) {

}
