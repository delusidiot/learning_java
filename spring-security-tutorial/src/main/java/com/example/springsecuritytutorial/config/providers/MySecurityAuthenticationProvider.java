package com.example.springsecuritytutorial.config.providers;

import com.example.springsecuritytutorial.config.MySecurityAuthentication;
import com.example.springsecuritytutorial.config.MyUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class MySecurityAuthenticationProvider implements AuthenticationProvider {

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;

    public MySecurityAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.err.println("MySecurityAuthenticationProvider");
        var authRequest = (MySecurityAuthentication) authentication;
        String password = authRequest.getPassword();
        String username = authRequest.getName();
        if ("Test".equals(username))
            return null;
        MyUser user = (MyUser) userDetailsService.loadUserByUsername(username);
        if (!this.passwordEncoder.matches(password, user.getPassword()) || !user.getUsername().equals(username))
            throw new BadCredentialsException("Invalid credentials!");
        return MySecurityAuthentication.authenticated(user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MySecurityAuthentication.class.isAssignableFrom(authentication);
    }
}
