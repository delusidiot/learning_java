package com.example.springsecuritytutorial.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serial;
import java.util.Collection;
import java.util.Collections;

public class MySecurityAuthentication implements Authentication {

    @Serial
    private static final long serialVersionUID = 1L;

    private final boolean isAuthenticated;
    private final String name;
    private final String password;
    private final MyUser myUser;
    private final Collection<GrantedAuthority> authorities;

    public MySecurityAuthentication(Collection<GrantedAuthority> authorities, String name, String password, MyUser myUser) {
        this.authorities = authorities;
        this.name = name;
        this.password = password;
        this.myUser = myUser;
        this.isAuthenticated = password == null;
    }

    public static MySecurityAuthentication unauthenticated(String name, String password) {
        return new MySecurityAuthentication(Collections.emptyList(), name, password, null);
    }

    public static MySecurityAuthentication authenticated(MyUser myUser) {
        return new MySecurityAuthentication(Collections.emptyList(), myUser.getUsername(), null, myUser);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getDetails() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return myUser;
    }

    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        throw new IllegalArgumentException("Don't do this");
    }

    @Override
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
