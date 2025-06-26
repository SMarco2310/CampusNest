package com.example.campusnest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Review_id")
    private Long id;

    @Column(nullable = false, name = "student_id")
    private Long userId; // who wrote the review

    @Column(nullable = false, name = "hostel_id")
    private Long hostel; // the hostel being reviewed
    @Column(nullable = true, name = "comments")
    private String comments; // detailed comments
    @Column(nullable = false, name = "ratings")
    private int rating; // Optional: a 1-5 star rating
    @Column(nullable = false, name = "created_At")
    private LocalDateTime createdAt;

    public Review() {
        // Default constructor
    }
}
