package com.hms.guest_management_service.services;

import com.hms.guest_management_service.entities.Guest;
import com.hms.guest_management_service.repositories.GuestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GuestService {
    private final GuestRepository guestRepository;

    public Guest addGuest(Guest guest) {
        return guestRepository.save(guest);
    }

    public List<Guest> getAllGuests() {
        return guestRepository.findAll();
    }

    public Optional<Guest> getGuestById(Long id) {
        return guestRepository.findById(id);
    }

    public Guest updateGuest(Long id, Guest guestDetails) {
        return guestRepository.findById(id).map(guest -> {
            guest.setFirstName(guestDetails.getFirstName());
            guest.setLastName(guestDetails.getLastName());
            guest.setPhoneNumber(guestDetails.getPhoneNumber());
            guest.setEmail(guestDetails.getEmail());
            guest.setAddress(guestDetails.getAddress());
            return guestRepository.save(guest);
        }).orElse(null);
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
