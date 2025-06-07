package com.example.campusnest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignupRequest {
    // Getters and Setters
    private String email;
    private String password;
    private String displayName;
    private String phoneNumber;
    private String role; // e.g., "USER", "ADMIN", "HOSTEL_MANAGER"

}
