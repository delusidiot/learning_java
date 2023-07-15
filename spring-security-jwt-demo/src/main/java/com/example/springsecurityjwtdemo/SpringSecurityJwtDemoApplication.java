package com.example.springsecurityjwtdemo;

import com.example.springsecurityjwtdemo.user.User;
import com.example.springsecurityjwtdemo.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.example.springsecurityjwtdemo.user.Role.ADMIN;
import static com.example.springsecurityjwtdemo.user.Role.MANAGER;

@SpringBootApplication
public class SpringSecurityJwtDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            userRepository.save(
                    User.builder()
                            .firstname("ADMIN")
                            .lastname("😊")
                            .email("admin@test.com")
                            .password(passwordEncoder.encode("1234"))
                            .role(ADMIN)
                            .build()
            );
            userRepository.save(
                    User.builder()
                            .firstname("MANAGER")
                            .lastname("😊")
                            .email("manager@test.com")
                            .password(passwordEncoder.encode("1234"))
                            .role(MANAGER)
                            .build()
            );
        };
    }
}
