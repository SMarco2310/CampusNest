package com.example.campusnest.repository;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHostel_Id(Long hostelId);

    List<Room> findAllByNumberOfBeds(int numberOfBeds);

    List<Room> findAllByPricePerBedBetween(double startPrice, double endPrice);

    Room findByRoomNumberAndHostel_Id(String roomNumber, Long hostelId);
}