package com.example.campusnest.repository;

import com.example.campusnest.entity.Hostel;
import com.example.campusnest.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface RoomRepository extends JpaRepository<Room, Long> {
    List<Room> findAllByHostelId(Hostel hostel_Id);

    List<Room> findAllByNumberOfBeds(int numberOfBeds);


    List<Room> findAllByPricePerBedBetween(double startPrice, double endPrice);

    Room findByRoomNumberAndHostelId(String roomNumber, Hostel hostelId);
}
