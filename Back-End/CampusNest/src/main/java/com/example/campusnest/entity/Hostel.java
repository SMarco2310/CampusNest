package com.example.campusnest.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity

public class Hostel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "hostel_id")
    private Long id; // Unique identifier for the hostel
    @Column(nullable = false, name = "Hostel_name")
    private String name; // e.g., "Hostel A", "Hostel B"
    @Column(nullable = false, name = "Hostel_location")
    private String location; // e.g., "North Campus", "South Campus"
    @Column(nullable = true)
    private String description; // e.g., "A comfortable hostel with modern amenities"
    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private User manager; // The user who manages the hostel
    @Column(nullable = false, name = "hostel_contact")
    private String contact; // Contact number for the hostel
}
