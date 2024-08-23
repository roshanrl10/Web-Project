package org.example.bikerental.controller;

import lombok.RequiredArgsConstructor;
import org.example.bikerental.entity.BikeBookingEntity;
import org.example.bikerental.pojo.BikeBookingPojo;
import org.example.bikerental.service.BikeBookingService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikebooking")
@RequiredArgsConstructor
public class BikeBookingController {

    private final BikeBookingService bikeBookingService;

    @PostMapping("/bikebook")
    public void saveBikeBooking(@RequestBody BikeBookingPojo bikeBook) {
        bikeBookingService.saveBikeBooking(bikeBook);
    }

    @GetMapping("/all")
    public List<BikeBookingEntity> getAllBikeBookings() {
        return bikeBookingService.getAllBikeBookings();
    }

    @GetMapping("/all/{id}")
    public Optional<BikeBookingEntity> getBikeBookingById(@PathVariable Integer id) {
        return bikeBookingService.getBikeBookingById(id);
    }

    @DeleteMapping("/all/{id}")
    public void deleteBikeBooking(@PathVariable Integer id) {
        bikeBookingService.deleteBikeBooking(id);
    }
}
