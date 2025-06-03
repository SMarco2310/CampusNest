package com.example.campusnest.repository;

import com.example.campusnest.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
}
