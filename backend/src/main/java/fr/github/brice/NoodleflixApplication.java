package fr.github.brice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "fr.github.brice.movies")
public class NoodleflixApplication {
    public static void main(String[] args) {
        SpringApplication.run(NoodleflixApplication.class, args);
    }
}
