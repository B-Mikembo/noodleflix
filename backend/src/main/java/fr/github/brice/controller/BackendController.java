package fr.github.brice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BackendController {
    public static final String HELLO_TEXT = "Hello from Spring Boot Backend!";

    @GetMapping("/hello")
    public String sayHello() {
        return HELLO_TEXT;
    }
}
