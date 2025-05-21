package com.hms.guest_management_service.repositories;

import com.hms.guest_management_service.entities.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
