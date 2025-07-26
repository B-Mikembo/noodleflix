package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.gateway.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static fr.github.brice.movies.MovieFixture.theDemonSlayer;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RestResourceTest
@DisplayName("Movie controller test")
public class MovieControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private MovieRepository movieRepository;

    @Test
    void shouldReturnStatusOkWhenGetMovies() throws Exception {
        movieRepository.save(theDemonSlayer());

        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movies", hasSize(1)))
                .andExpect(jsonPath("$.movies[0].title").value("Demon Slayer: Kimetsu no Yaiba Infinity Castle"))
                .andExpect(jsonPath("$.movies[0].voteAverage").value(6.827))
                .andExpect(jsonPath("$.movies[0].posterPath").value("/aFRDH3P7TX61FVGpaLhKr6QiOC1.jpg"))
                .andExpect(jsonPath("$.movies[0].releaseDate").value("2025-07-18"))
                .andExpect(jsonPath("$.movies[0].originalLanguage").value("ja"));
    }
}
