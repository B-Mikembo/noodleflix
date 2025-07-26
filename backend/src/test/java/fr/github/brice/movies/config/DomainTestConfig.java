package fr.github.brice.movies.config;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.gateway.stub.InMemoryMovieRepository;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@TestConfiguration
public class DomainTestConfig {
    @Bean
    MovieRepository movieRepository() {
        return new InMemoryMovieRepository();
    }
}
