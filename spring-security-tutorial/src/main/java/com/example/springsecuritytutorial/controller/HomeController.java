package com.example.springsecuritytutorial.controller;


import com.example.springsecuritytutorial.config.MyUser;
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
        MyUser principal = (MyUser) authentication.getPrincipal();
        return String.format("<h1>Welcome %s Admin!</h1> <h2> %s </h2> <ol><li>%s</li><li>%s</li></ol>",
                authentication.getName(), authentication.getAuthorities(), principal.getFullName(), principal.getBirthdate());
    }
}
