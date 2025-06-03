package com.example.campusnest.repository;

import com.example.campusnest.entity.Hostel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface HostelRepository extends JpaRepository<Hostel, Long> {
}
