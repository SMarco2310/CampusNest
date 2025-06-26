package com.example.campusnest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity

public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "complaint_id")
    private Long id; // Unique identifier for the complaint
    @Column(nullable = false, name = "hostel_id")
    private Long hostelId;
    @Column(nullable = false, name = "message")
    private String message; // The complaint message
    @Column(nullable = false, name = "submission_date")
    private LocalDateTime submissionDate; // Date and time when the complaint was submitted

    public Complaint() {

    }
}
