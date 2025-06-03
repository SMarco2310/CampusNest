package com.example.campusnest.utils;

public enum Role {

    ADMIN("ADMIN"),
    HOSTEL_MANAGER("HOSTEL_MANAGER"),
    STUDENT("STUDENT");

    private final String role;

    Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
