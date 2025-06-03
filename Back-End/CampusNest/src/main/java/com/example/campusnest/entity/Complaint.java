package com.example.campusnest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
@Entity

public class Complaint {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(nullable = false, name = "complaint_id")
    private Long id; // Unique identifier for the complaint
    @ManyToOne
    @JoinColumn(nullable = false, name = "hostel_id")
    private Hostel hostel;
    @Column(nullable = false, name="message")
    private String message; // The complaint message
    @Column(nullable = false,name= "submission_date")
    private Timestamp submissionDate; // Date and time when the complaint was submitted
}
