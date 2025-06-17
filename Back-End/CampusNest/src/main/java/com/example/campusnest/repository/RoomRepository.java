package com.example.campusnest.repository;


import com.example.campusnest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

//    @Query("SELECT r FROM Room r JOIN r.hostelId h WHERE h.hostel_id = :hostelId")
    List<Room> findAllByHostelId( Long hostelId);

    List<Room> findAllByNumberOfBeds(int numberOfBeds);

    List<Room> findAllByPricePerBedBetween(double startPrice, double endPrice);

    Room findByRoomNumberAndHostelId(String roomNumber, Long hostelId);
}