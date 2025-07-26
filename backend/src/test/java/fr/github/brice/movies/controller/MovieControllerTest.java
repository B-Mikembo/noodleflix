package fr.github.brice.movies.controller;

import fr.github.brice.movies.business.gateway.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        mockMvc.perform(get("/api/movies"))
                .andExpect(status().isOk());
    }
}
