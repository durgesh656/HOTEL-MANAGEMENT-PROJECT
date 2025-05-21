package com.hms.room_management_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String roomNumber;
    private String type; // e.g., Single, Double, Suite
    private Double price;
    private boolean available;

//    @Override
//    public String toString() {
//        return "Room{" +
//                "id=" + id +
//                ", roomNumber='" + roomNumber + '\'' +
//                ", type='" + type + '\'' +
//                ", price=" + price +
//                ", available=" + available +
//                '}';
//    }
}
