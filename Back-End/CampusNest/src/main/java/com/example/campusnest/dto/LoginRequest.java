package com.example.campusnest.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String idToken;
    private String email;
    private String password;

}
