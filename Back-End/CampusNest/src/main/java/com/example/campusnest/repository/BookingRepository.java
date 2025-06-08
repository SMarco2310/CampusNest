package com.example.campusnest.repository;

import com.example.campusnest.entity.Booking;
import com.example.campusnest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByStudent(User student);
}
