package com.example.campusnest.service;

import com.example.campusnest.entity.Review;
import com.example.campusnest.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;


    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    // Add methods to handle reviews, e.g., create, update, delete, fetch reviews
    // Example method to create a review
    public void createReview(Review review) {
         Review newReview = new Review();
        newReview.setHostel(review.getHostel());
        newReview.setRating(review.getRating());
        newReview.setComments(review.getComments());
        newReview.setUserId(review.getUserId());
        newReview.setCreatedAt(review.getCreatedAt());
        reviewRepository.save(newReview);
    }
    // Example method to retrieve all reviews
    public List<Review> getAllReviews() {
        // This method retrieves all reviews from the repository
        return reviewRepository.findAll();
    }
    // Example method to retrieve reviews by hostel ID
    public List<Review> getReviewsByHostelId(Long hostelId) {
        // This method retrieves all reviews associated with a specific hostel
        return reviewRepository.findByHostel(hostelId);
    }
    // Additional methods for review management can be added here
    public void deleteReview(Long reviewId) {
        // This method deletes a review by its ID
        reviewRepository.deleteById(reviewId);
    }
}
