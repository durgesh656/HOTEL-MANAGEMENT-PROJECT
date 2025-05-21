package com.hms.room_management_service.services;

import com.hms.room_management_service.entities.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room addRoom(Room room);
    List<Room> getAllRooms();
    Optional<Room> getRoomById(Long id);
   // Room updateRoom(Long id, Room room);
    void deleteRoom(Long id);
}
