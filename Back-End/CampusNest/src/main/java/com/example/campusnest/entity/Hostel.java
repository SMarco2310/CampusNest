package com.example.campusnest.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter // Lombok will generate setters for all fields
@Getter // Lombok will generate getters for all fields
@Entity // Marks this class as a JPA entity, mapped to a database table
@Table(name = "hostel") // Explicitly define the table name (optional, defaults to class name)
public class Hostel {

    @Id // Marks this field as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments the ID in the database
    @Column(name = "hostel_id") // Maps this field to the 'hostel_id' column in the database
    private Long id; // Unique identifier for the hostel

    @Column(nullable = false, name = "hostel_name") // Maps to 'hostel_name' column, cannot be null
    @JsonProperty("hostelName") // Maps 'hostelName' from incoming JSON to this field
    private String name; // e.g., "Hostel A", "Hostel B"

    @Column(nullable = false, name = "hostel_location") // Maps to 'hostel_address' column, cannot be null
    @JsonProperty("hostelAddress") // Maps 'hostelAddress' from incoming JSON to this field
    private String location; // e.g., "123 Main St, City, Country"

    @Column(nullable = true, name = "description", length = 1000) // Maps to 'hostel_description', can be null, sets max length
    @JsonProperty("hostelDescription") // Maps 'hostelDescription' from incoming JSON to this field
    private String description; // e.g., "A comfortable hostel with modern amenities"

    @Column(nullable = true, name = "hostel_rating") // Maps to 'hostel_rating', can be null
    @JsonProperty("hostelRating") // Maps 'hostelRating' from incoming JSON to this field
    private Double rating; // e.g., 4.5

    // Combining hostelPhoneNumber and hostelEmail into separate fields for clarity and better data structure
    @Column(nullable = false, name = "hostel_phone_number") // Maps to 'hostel_phone_number', cannot be null
    @JsonProperty("hostelPhoneNumber") // Maps 'hostelPhoneNumber' from incoming JSON to this field
    private String phoneNumber;

    @Column(nullable = false, name = "hostel_email") // Maps to 'hostel_email', cannot be null
    @JsonProperty("hostelEmail") // Maps 'hostelEmail' from incoming JSON to this field
    private String email;

    // Assuming User is another entity, representing the manager of the hostel
    // This creates a Many-to-One relationship where many hostels can be managed by one user
    @JoinColumn(name = "manager_id", nullable = false) // Foreign key column in the 'hostels' table
    private Long managerId; // The user entity linked as the manager of the hostel

    // Default constructor is required by JPA
    public Hostel() {
    }

    // You don't need to manually write getters and setters if you use Lombok's @Getter and @Setter
    // but if you remove Lombok, you'd need them here.
}