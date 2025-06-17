package com.example.campusnest.utils;

import com.example.campusnest.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;


@Component
public class JwtUtil {
    private final static String secret = "BRp6w49W2iWQDhNCOnGXjnRshQ0htwYZ8ldqIOPZN6g="; // Secure key: 40+ chars
    private final SecretKey secretKey = Keys.hmacShaKeyFor(
            secret.getBytes() // Use a secure key of at least 256 bits (32 bytes)
                );
    @Autowired
    private final UserService userService;

    public JwtUtil(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public  String generateToken(String email) {
        Date now = new Date();
        String role = String.valueOf(userService.findByEmail(email).getRole()); // Assuming you have a method to get user role
        Date expiry = new Date(now.getTime() + 1000 * 60 * 60); // 1h
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role) // Example claim
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String validateAndGetSubject(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
    }

}
