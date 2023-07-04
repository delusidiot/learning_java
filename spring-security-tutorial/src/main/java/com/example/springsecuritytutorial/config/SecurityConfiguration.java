package com.example.springsecuritytutorial.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    @Order(100)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/user")
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.GET, "/").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER", "OIDC_USER");
                    authorize.anyRequest().authenticated();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(101)
    SecurityFilterChain securityFilterChainAdmin(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/admin")
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN");
                    authorize.anyRequest().authenticated();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(102)
    SecurityFilterChain securityFilterChainHome(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/")
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().permitAll();
                })
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    @Order(103)
    SecurityFilterChain securityFilterChainOther(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> {
                    authorize.anyRequest().denyAll();
                })
                .formLogin(withDefaults());
        return http.build();
    }
    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    DataSource dataSource() {
        return DataSourceBuilder.create()
                .driverClassName("org.mariadb.jdbc.Driver")
                .url("jdbc:mariadb://192.168.0.18:3306/test")
                .username("test")
                .password("test")
                .build();
    }
}
