package com.example.springsecuritytutorial;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringSecurityTutorialApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityTutorialApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(JdbcUserDetailsManager jdbcUserDetailsManager, DataSource dataSource) {
        return arg -> {
            UserDetails admin = User.builder()
                    .username("admin")
                    .password("{noop}admin")
                    .roles("USER", "ADMIN")
                    .build();
            UserDetails user = User.builder()
                    .username("member")
                    .password("{noop}member")
                    .roles("USER")
                    .build();
            JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
            users.createUser(admin);
            users.createUser(user);
        };
    }
}
