package com.example.springsecuritytutorial.controller;


import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome home";
    }

    @GetMapping("/user")
    public String user(Authentication authentication) {
        return String.format("<h1>Welcome %s !</h1><h2> %s </h2>", authentication.getName(), authentication.getAuthorities());
    }

    @GetMapping("/admin")
    public String admin(Authentication authentication) {
        return String.format("<h1>Welcome %s Admin!</h1> <h2> %s </h2>", authentication.getName(), authentication.getAuthorities());
    }
}
