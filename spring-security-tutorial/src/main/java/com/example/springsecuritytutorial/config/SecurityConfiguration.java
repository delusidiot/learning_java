package com.example.springsecuritytutorial.config;

import com.example.springsecuritytutorial.config.providers.MySecurityAuthenticationProvider;
import com.example.springsecuritytutorial.config.providers.TestAuthenticationProvider;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationEventPublisher publisher, UserDetailsService userDetailsService) throws Exception {
        List<AuthenticationProvider> lijst = new ArrayList<>();
        lijst.add(new MySecurityAuthenticationProvider(userDetailsService));
        lijst.add(new TestAuthenticationProvider());
        ProviderManager providerManager = new ProviderManager(lijst);
        providerManager.setAuthenticationEventPublisher(publisher);
        http
                .authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers(HttpMethod.GET, "/").permitAll();
                    authorize.requestMatchers(HttpMethod.GET, "/user/**").hasRole("USER");
                    authorize.requestMatchers(HttpMethod.GET, "/admin/**").hasRole("ADMIN");
                    authorize.anyRequest().authenticated();
                })
                .csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new MySecurityFilter(providerManager), UsernamePasswordAuthenticationFilter.class)
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public ApplicationListener<AuthenticationSuccessEvent> successEvent() {
            return event -> System.err.printf("Success Login %s - %s%n",event.getAuthentication().getClass().getName(), event.getAuthentication().getName() );
    }

    @Bean
    public ApplicationListener<AuthenticationFailureBadCredentialsEvent> failureEvent() {
        return event -> System.err.printf("Bad Credentials Login %s - %s%n",event.getAuthentication().getClass().getName(), event.getAuthentication().getName() );
    }
}
