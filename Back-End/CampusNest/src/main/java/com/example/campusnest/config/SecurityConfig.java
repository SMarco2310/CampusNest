package com.example.campusnest.config;


import com.example.campusnest.service.UserService;
import com.example.campusnest.utils.CustomAccessDeniedHandler;
import com.example.campusnest.utils.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.example.campusnest.utils.JwtUtil.passwordEncoder;

@Configuration
public class SecurityConfig {

    private final UserService userService;
    private CustomAccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    // 1. Security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthFilter) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/api/v1/auth/signup", "/api/v1/auth/login","/api/v1/hostels/create","/api/v1/hostels/all","/api/v1/rooms/create","/api/v1/rooms/all","/api/v1/rooms/by-price", "/api/v1/rooms/{id}", "/api/v1/rooms/{hostelId}","/api/v1/auth/profile").permitAll()
                        .requestMatchers("/api/v1/auth/all").hasRole("ADMIN") // Only ADMIN can access this endpoint
                        .requestMatchers("/api/v1/rooms/create","/api/v1/hostels/create").hasRole("MANAGER") // Only HOSTEL_OWNER can access hostel-related endpoints
                        .anyRequest().authenticated()
                )
                .userDetailsService(userService)
                .exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler).authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))

                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // 2. AuthenticationManager Bean (to be injected wherever needed)
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(UserService userService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}

