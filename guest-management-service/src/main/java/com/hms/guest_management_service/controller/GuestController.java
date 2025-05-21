package com.hms.guest_management_service.controller;

import com.hms.guest_management_service.entities.Guest;
import com.hms.guest_management_service.services.GuestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/guests")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {
        return ResponseEntity.ok(guestService.addGuest(guest));
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests() {
        return ResponseEntity.ok(guestService.getAllGuests());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getGuestById(@PathVariable Long id) {
        return guestService.getGuestById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build ());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Guest> updateGuest(@PathVariable Long id, @RequestBody Guest guest) {
        Guest updated = guestService.updateGuest(id, guest);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGuest(@PathVariable Long id) {
        guestService.deleteGuest(id);
        return ResponseEntity.noContent().build();
    }
}
