package com.hms.room_management_service.controller;


import com.hms.room_management_service.entities.Room;
import com.hms.room_management_service.services.RoomService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")

public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        System.out.println("Received Room: " + room);
        return ResponseEntity.ok(roomService.addRoom(room));
    }

    @GetMapping
    public ResponseEntity<List<Room>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Long id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Room> updateRoom(@PathVariable Long id, @RequestBody Room room) {
//        Room updated = roomService.updateRoom(id, room);
//        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
