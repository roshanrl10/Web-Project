package org.example.bikerental.service;

import java.util.List;
import java.util.Optional;
import org.example.bikerental.entity.BikeBookingEntity;
import org.example.bikerental.pojo.BikeBookingPojo;

public interface BikeBookingService {

    /**
     * Saves a bike booking.
     *
     * @param bikeBookingPojo The bike booking details to be saved.
     */
    void saveBikeBooking(BikeBookingPojo bikeBookingPojo);

    /**
     * Retrieves all bike bookings.
     *
     * @return A list of all bike bookings.
     */
    List<BikeBookingEntity> getAllBikeBookings();

    /**
     * Retrieves a bike booking by its ID.
     *
     * @param id The ID of the bike booking to retrieve.
     * @return An Optional containing the bike booking if found, otherwise empty.
     */
    Optional<BikeBookingEntity> getBikeBookingById(Integer id);

    /**
     * Deletes a bike booking by its ID.
     *
     * @param id The ID of the bike booking to be deleted.
     */
    void deleteBikeBooking(Integer id);
}
