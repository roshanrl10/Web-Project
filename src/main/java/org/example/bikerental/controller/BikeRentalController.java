package org.example.bikerental.controller;

import lombok.RequiredArgsConstructor;
import org.example.bikerental.entity.BikeRentalEntity;
import org.example.bikerental.pojo.BikeRentalPojo;
import org.example.bikerental.service.BikeRentalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bikes")
@RequiredArgsConstructor
public class BikeRentalController {

    private final BikeRentalService bikeRentalService;

    @PostMapping("/add")
    public ResponseEntity<?> addBike(
            @RequestParam("bikeBrand") String bikeBrand,
            @RequestParam("seat") int seat,
            @RequestParam("price") int price,
            @RequestParam(value = "bikeImage", required = false) MultipartFile bikeImage) {

        BikeRentalPojo bikeRentalPojo = new BikeRentalPojo();
        bikeRentalPojo.setBikeBrand(bikeBrand);
        bikeRentalPojo.setSeat(seat);
        bikeRentalPojo.setPrice(price);

        if (bikeImage != null && !bikeImage.isEmpty()) {
            bikeRentalPojo.setBikeImage(bikeImage);
        }

        try {
            bikeRentalService.saveBikeRental(bikeRentalPojo);
            return ResponseEntity.ok("Bike added successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving bike");
        }
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<?> updateBike(
            @PathVariable("id") Long id,
            @RequestParam("bikeBrand") String bikeBrand,
            @RequestParam("seat") int seat,
            @RequestParam("price") String price,
            @RequestParam(value = "bikeImage", required = false) MultipartFile bikeImage) {

        // Ensure validation here, if necessary
        if (bikeBrand.isEmpty() || seat <= 0 || price.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid input data");
        }

        // Your logic to update the bike goes here
        return ResponseEntity.ok("Bike updated successfully");
    }

    @GetMapping("/list")
    public List<BikeRentalEntity> getAllBikeRentals() {
        return bikeRentalService.getAllBikeRentals();
    }

    @GetMapping("/list/{id}")
    public Optional<BikeRentalEntity> getBikeRentalById(@PathVariable Integer id) {
        return bikeRentalService.getBikeRentalById(id);
    }

    @DeleteMapping("/list/{id}")
    public void deleteBikeRental(@PathVariable Integer id) {
        bikeRentalService.deleteBikeRental(id);
    }
}
