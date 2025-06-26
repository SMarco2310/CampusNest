package com.example.campusnest.entity;


import com.example.campusnest.utils.BookingStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity

public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "booking_id")
    private Long id; // Unique identifier for the booking
    @Column(nullable = false, name = "Student_id")
    @JsonProperty("student_id")
    private Long student; // The user who made the booking
    @Column(nullable = false, name = "room_id")
    @JsonProperty("room_id")
    private Long room;
    @Column(name = "preferred_roommate_name",nullable = false)
    @JsonProperty("preferred_roommate_name")
    private String preferredRoommateName; // optional input by name or tag
    @Column(nullable = false, name = "booking_date")
    @JsonProperty("booking_date")
    private LocalDateTime bookingDate; // Date of the booking in "YYYY-MM-DD" format
    @Column(nullable = false, name = "status")
    @JsonProperty("status")
    private BookingStatus status; // e.g., "CONFIRMED", "CANCELLED", "PENDING"

    public Booking() {
        // Default constructor
    }

}
