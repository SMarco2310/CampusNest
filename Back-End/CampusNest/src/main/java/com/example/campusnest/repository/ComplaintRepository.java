package com.example.campusnest.repository;

import com.example.campusnest.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findAllByHostel_Id(Long hostelId);
}
