package com.example.campusnest.repository;

import com.example.campusnest.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByHostel(long hostelId);
}
