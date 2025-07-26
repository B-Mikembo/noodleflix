package fr.github.brice.movies.gateway;

import fr.github.brice.movies.business.gateway.MovieRepository;
import fr.github.brice.movies.business.rules.ReplaceCamelCase;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("TMDB client test")
@DisplayNameGeneration(ReplaceCamelCase.class)
class TMDBClientTest {
    @Value("${tmdb-api.baseUrl}")
    private String baseUrl;
    @Value("${tmdb-api.apiToken}")
    private String apiToken;
    private MockWebServer mockWebServer;
    private MovieRepository tmdbClient;

    @BeforeEach
    void setUp() {
        mockWebServer = new MockWebServer();
        var properties = new TMDBClientProperties();
        properties.setBaseUrl(mockWebServer.url(baseUrl).url().toString());
        properties.setApiToken(apiToken);
        tmdbClient = new TMDBClient(WebClient.create(), properties);
    }

    @Test
    void shouldMakeCorrectRequest() throws InterruptedException {
        mockWebServer.enqueue(
                new MockResponse().setResponseCode(200)
                        .setHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .setBody(getJson("movies-response.json"))
        );

        tmdbClient.findAll();

        var request = mockWebServer.takeRequest();
        assertThat(request.getMethod()).isEqualTo("GET");
        assertThat(request.getHeader(HttpHeaders.AUTHORIZATION)).isEqualTo(format("Bearer %s", apiToken));
        assertThat(request.getHeader(HttpHeaders.ACCEPT)).isEqualTo(MediaType.APPLICATION_JSON_VALUE);
        assertThat(request.getPath()).isEqualTo("/discover/movie?sort_by=popularity.desc");
    }

    private String getJson(String path) {
        try (var jsonStream = this.getClass().getClassLoader().getResourceAsStream(path)) {
            if (jsonStream == null)
                throw new IllegalStateException(format("Le fichier %s n'a pas pu être chargé", path));
            return new String(jsonStream.readAllBytes());
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}