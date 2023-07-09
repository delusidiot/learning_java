package com.example.springsecuritytutorial.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (username.equals("member"))
            return User.builder()
                    .username("member")
                    .password("member")
                    .roles("USER", "ADMIN")
                    .disabled(false)
                    .build();
        throw new UsernameNotFoundException(username);
    }
}
