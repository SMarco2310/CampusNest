package com.example.campusnest.controller;


import com.example.campusnest.entity.Review;
import com.example.campusnest.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller("/api/v1/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/review")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        // Logic to create a review will be implemented here
        reviewRepository.save(review);
        return ResponseEntity.ok("Review created successfully"); // Placeholder response
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        // Logic to retrieve all reviews will be implemented here
        List<Review> reviews = reviewRepository.findAll();
        return ResponseEntity.ok(reviews); // Placeholder response
    }
    @GetMapping("/reviews/{hostelId}")
    public ResponseEntity<List<Review>> getReviewsByHostelId(Long hostelId) {
        // Logic to retrieve reviews by hostel ID will be implemented here
        List<Review> reviews = reviewRepository.findByHostel_Id(hostelId); // Placeholder logic
        return ResponseEntity.ok(reviews); // Placeholder response
    }
}
