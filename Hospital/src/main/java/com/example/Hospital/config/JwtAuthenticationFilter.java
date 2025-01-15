package com.example.Hospital.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil = null;
    private final CustomUserDetailsService customUserDetailsService = null;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorization = request.getHeader("Authorization");
        if(authorization != null && authorization.startsWith("Bearer")){
            String token = authorization.substring(7);
            String email = jwtUtil.extragereUsername(token);

            if(email != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);
            }
        }
    }
}
