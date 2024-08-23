package org.example.bikerental.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BikeBookingPojo {
    private Integer id;
    private Integer bikeId; // Updated from carId to bikeId
    private Integer userId;
    private LocalDateTime rentalStartDateTime; // Renamed for clarity
    private LocalDateTime rentalEndDateTime; // Renamed for clarity
    private Double totalAmount;
}
