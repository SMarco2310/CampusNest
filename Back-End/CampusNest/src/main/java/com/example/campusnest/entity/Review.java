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

    @ManyToOne
    @JoinColumn(nullable = false, name = "student_id")
    private User user; // who wrote the review

    @ManyToOne
    @JoinColumn(nullable = false, name = "hostel_id")
    private Hostel hostel; // the hostel being reviewed
    @Column(nullable = true, name = "comments")
    private String comments; // detailed comments
    @Column(nullable = false, name = "ratings")
    private int rating; // Optional: a 1-5 star rating
    @Column(nullable = false, name = "created_At")
    private LocalDateTime createdAt;
}
