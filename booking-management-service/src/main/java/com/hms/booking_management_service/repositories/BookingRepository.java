package com.hms.booking_management_service.repositories;

import com.hms.booking_management_service.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
