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
                                // Public endpoints (no auth required)
                                .requestMatchers(
                                        "/api/v1/auth/signup",
                                        "/api/v1/auth/login",
                                        "/api/v1/hostels/all",
                                        "/api/v1/rooms/all",
                                        "/api/v1/rooms/by-price",
                                        "/api/v1/rooms/{id}",
                                        "/api/v1/rooms/{hostelId}"
                                ).permitAll()

                                // ADMIN only endpoints
                                .requestMatchers(
                                        "/api/v1/auth/all",
                                        "/api/v1/complaints/all"
                                ).hasRole("ADMIN")

                                // MANAGER (Hostel Owner) endpoints
                                .requestMatchers(
                                        "/api/v1/hostels/create",
                                        "/api/v1/rooms/create",
                                        "/api/v1/rooms/{id}" // PUT update
                                ).hasRole("MANAGER")

                                // STUDENT-only endpoints
                                .requestMatchers(
                                        "/api/v1/bookings/book",       // Book a room
                                        "/api/v1/complaints/create",          // Submit a complaint
                                        "/api/v1/reviews/create"// Create/view reviews
                                ).hasRole("STUDENT")

                                // Shared endpoints (any authenticated user)
                                .requestMatchers(
                                        "/api/v1/auth/profile",
                                        "/api/v1/complaints/{hostelId}"       // View complaints for a hostel
                                ).authenticated()
                                .anyRequest().denyAll()
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

