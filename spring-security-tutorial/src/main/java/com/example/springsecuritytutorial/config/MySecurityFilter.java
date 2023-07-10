package com.example.springsecuritytutorial.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

public class MySecurityFilter extends OncePerRequestFilter {

    private final String HEADER_LOGIN = "x-myfilter-login";
    private final String HEADER_PASSWORD = "x-myfilter-password";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("\n\nBefore filterChain\n\n");

        if (!Collections.list(request.getHeaderNames()).contains(HEADER_LOGIN) || !Collections.list(request.getHeaderNames()).contains(HEADER_PASSWORD)){
            System.out.println("No Headers");
            filterChain.doFilter(request, response);
            return;
        }
        String id = request.getHeader(HEADER_LOGIN);
        String password = request.getHeader(HEADER_PASSWORD);

        if (!"Developer".equals(id) || !"password".equals(password)) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().println("YOU ARE NOT THE DEVELOPER");
            return;
        }
        System.out.println("Headers:" + id + " - " + password);
        SecurityContext newContext = SecurityContextHolder.createEmptyContext();
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(id, null,
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN", "ROLE_DEVELOPER"));
        newContext.setAuthentication(authReq);
        SecurityContextHolder.setContext(newContext);
        filterChain.doFilter(request, response);
        System.out.println("\n\nAfter filterChain\n\n");
    }
}
