package com.hms.booking_management_service.services;

import com.hms.booking_management_service.entities.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking createBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    void deleteBooking(Long id);
}
