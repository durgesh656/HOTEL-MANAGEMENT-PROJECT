package com.hms.room_management_service.repositories;

import com.hms.room_management_service.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
