package com.example.springsecurityjwtdemo.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.springsecurityjwtdemo.user.Permission.*;
import static com.example.springsecurityjwtdemo.user.Role.ADMIN;
import static com.example.springsecurityjwtdemo.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/api/auth/**").permitAll();

                    authorize.requestMatchers("/api/management/**").hasAnyRole(ADMIN.name(), MANAGER.name());
                    authorize.requestMatchers(GET, "/api/management/**").hasAnyAuthority(ADMIN_READ.name(), MANAGER_READ.name());
                    authorize.requestMatchers(POST, "/api/management/**").hasAnyAuthority(ADMIN_CREATE.name(), MANAGER_CREATE.name());
                    authorize.requestMatchers(PUT, "/api/management/**").hasAnyAuthority(ADMIN_UPDATE.name(), MANAGER_UPDATE.name());
                    authorize.requestMatchers(DELETE, "/api/management/**").hasAnyAuthority(ADMIN_DELETE.name(), MANAGER_DELETE.name());

//                    authorize.requestMatchers("/api/admin/**").hasRole(ADMIN.name());
//                    authorize.requestMatchers(GET, "/api/admin/**").hasAuthority(ADMIN_READ.name());
//                    authorize.requestMatchers(POST, "/api/admin/**").hasAuthority(ADMIN_CREATE.name());
//                    authorize.requestMatchers(PUT, "/api/admin/**").hasAuthority(ADMIN_UPDATE.name());
//                    authorize.requestMatchers(DELETE, "/api/admin/**").hasAuthority(ADMIN_DELETE.name());

                    authorize.anyRequest().authenticated();
                })
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout(logoutConfigurer -> {
                    logoutConfigurer.logoutUrl("/api/auth/logout");
                    logoutConfigurer.addLogoutHandler(logoutHandler);
                    logoutConfigurer.logoutSuccessHandler((request, response, authentication) ->
                            SecurityContextHolder.clearContext());
                });
        return http.build();
    }
}
