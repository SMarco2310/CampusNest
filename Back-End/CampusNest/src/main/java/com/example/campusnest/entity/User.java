package com.example.campusnest.entity;

import com.example.campusnest.utils.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;


@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false, name = "user_id")
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;
    @Column(nullable = false, unique = true, name = "username")
    private String username;
    @Column(nullable = true, name = "password")
    private String password;
    @Column(nullable = false, unique = true, name = "email")
    private String email;
    @Column(nullable = true, name = "phone_number")
    private String phoneNumber;

    private Role role; // e.g., "USER", "ADMIN"


}
