package com.example.campusnest.config;

import com.example.campusnest.security.FirebaseTokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final FirebaseTokenFilter firebaseTokenFilter;

    public SecurityConfig(FirebaseTokenFilter firebaseTokenFilter) {
        this.firebaseTokenFilter = firebaseTokenFilter;
    }


    // review the security configuration for the application
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        // Public endpoints (no authentication required)
                        .requestMatchers(
                                "/auth/**"  // All auth endpoints
                        ).permitAll()
                        // Manager role required endpoints
                        .requestMatchers(
                                "/api/v1/hostels/hostel",  // POST create hostel
                                "/api/v1/hostels/hostels",  // GET all hostels
                                "/rooms/rooms",  // GET all rooms
                                "/rooms/room/{id}",  // GET room by ID
                                "/rooms/room", // POST create room
                                "/rooms/room/update"  // POST update room
                        ).hasRole("MANAGER")
                        // User role required endpoints
                        .requestMatchers(
                                "/rooms/rooms",  // GET all rooms
                                "/rooms/hostel/", // GET rooms by hostel ID
                                "/bookings/book",  // POST book a room
                                "/api/v1/complaints/complaint",  // POST create complaint
                                "/api/v1/reviews/review",  // POST create review
                                "/api/v1/reviews/{hostelId}" // GET reviews by hostel ID
                        ).hasRole("USER")

                        // Admin role required endpoints
                        .requestMatchers(
                                "/bookings/bookings",  // GET all bookings
                                "/api/v1/complaints/{hostelId}",  // GET complaints by hostel ID
                                "/api/v1/complaints/complaints",  // GET all complaints
                                "/api/v1/hostels/hostel/update",  // POST update hostel
                                "/api/v1/hostels/hostels/{id}"  // GET hostel by ID
                        ).hasRole("ADMIN")

                        // All other requests require authentication
                        .anyRequest().authenticated()
                )
                .addFilterBefore(firebaseTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}