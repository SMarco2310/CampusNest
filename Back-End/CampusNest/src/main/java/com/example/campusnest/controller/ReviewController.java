package com.example.campusnest.controller;

import com.example.campusnest.entity.Review;
import com.example.campusnest.repository.ReviewRepository;
import com.example.campusnest.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createReview(@RequestBody Review review) {
        reviewService.createReview(review);
        return ResponseEntity.ok("Review created successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/{hostelId}")
    public ResponseEntity<List<Review>> getReviewsByHostelId(@PathVariable Long hostelId) {
        List<Review> reviews = reviewService.getReviewsByHostelId(hostelId);
        return ResponseEntity.ok(reviews);
    }
}