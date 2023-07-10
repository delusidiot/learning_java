package com.example.springsecuritytutorial.config.providers;

import com.example.springsecuritytutorial.config.MySecurityAuthentication;
import com.example.springsecuritytutorial.config.MyUser;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;

public record TestAuthenticationProvider() implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.err.println("Test Provider");
        var authRequest = (MySecurityAuthentication) authentication;
        String password = authRequest.getPassword();
        String username = authRequest.getName();
        if (!"Test".equals(username))
            return null;
        MyUser user = new MyUser(username, password, true, true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN", "ROLE_DEVELOPER"),
                "", "", "", null);
        return MySecurityAuthentication.authenticated(user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return MySecurityAuthentication.class.isAssignableFrom(authentication);
    }
}
