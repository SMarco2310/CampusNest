package com.example.campusnest.controller;

import com.example.campusnest.entity.Room;
import com.example.campusnest.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller("/api/v1/rooms")
public class RoomController {

    @Autowired
    public  RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/rooms")
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/rooms/{startPrice}/{endPrice}")
    public ResponseEntity<List<Room>> getRoomsByPriceRange(double startPrice, double endPrice) {
        return ResponseEntity.ok(roomService.getAllRoomsByPricePerBeds(startPrice, endPrice));
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(long id) {
        Room room = roomService.getRoomById(id);
        if (room != null) {
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/rooms/hostel/{hostelId}")
    public ResponseEntity<List<Room>> getRoomsByHostelId(long hostelId) {
        List<Room> rooms = roomService.findRoomsByHostelId(hostelId);
        if (rooms != null && !rooms.isEmpty()) {
            return ResponseEntity.ok(rooms);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
