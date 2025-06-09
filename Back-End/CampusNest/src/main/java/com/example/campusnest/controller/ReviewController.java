package com.example.campusnest.controller;

import com.example.campusnest.entity.Review;
import com.example.campusnest.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewRepository reviewRepository;

    public ReviewController(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        reviewRepository.save(review);
        return ResponseEntity.ok("Review created successfully");
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{hostelId}")
    public ResponseEntity<List<Review>> getReviewsByHostelId(@PathVariable Long hostelId) {
        List<Review> reviews = reviewRepository.findByHostel_Id(hostelId);
        return ResponseEntity.ok(reviews);
    }
}