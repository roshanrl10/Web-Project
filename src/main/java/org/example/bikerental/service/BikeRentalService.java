package org.example.bikerental.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.example.bikerental.entity.BikeRentalEntity;
import org.example.bikerental.pojo.BikeRentalPojo;

public interface BikeRentalService {

    /**
     * Saves a bike rental.
     *
     * @param bikeRentalPojo The bike rental details to be saved.
     * @throws IOException If there is an error saving the bike rental.
     */
    void saveBikeRental(BikeRentalPojo bikeRentalPojo) throws IOException;

    /**
     * Updates a bike rental.
     *
     * @param bikeRentalPojo The bike rental details to be updated.
     * @throws IOException If there is an error updating the bike rental.
     */
    void updateBike(BikeRentalPojo bikeRentalPojo) throws IOException;

    /**
     * Retrieves all bike rentals.
     *
     * @return A list of all bike rentals.
     */
    List<BikeRentalEntity> getAllBikeRentals();

    /**
     * Retrieves a bike rental by its ID.
     *
     * @param id The ID of the bike rental to retrieve.
     * @return An Optional containing the bike rental if found, otherwise empty.
     */
    Optional<BikeRentalEntity> getBikeRentalById(Integer id);

    /**
     * Deletes a bike rental by its ID.
     *
     * @param id The ID of the bike rental to be deleted.
     */
    void deleteBikeRental(Integer id);
}
