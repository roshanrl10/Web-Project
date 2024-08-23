package org.example.bikerental.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.bikerental.entity.BikeRentalEntity;
import org.example.bikerental.pojo.BikeRentalPojo;
import org.example.bikerental.repository.BikeRentalRepository;
import org.example.bikerental.service.BikeRentalService;
import org.example.bikerental.utils.ImageToBase64Bike; // Ensure you have a similar utility class for bikes
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BikeRentalServiceImpl implements BikeRentalService {

    private final BikeRentalRepository bikeRentalRepository;

    // Updated path to store images inside the project directory
    private final String UPLOAD_DIRECTORY = "src/main/resources/uploads/bikes";

    @Override
    public void saveBikeRental(BikeRentalPojo bikeRentalPojo) throws IOException {
        BikeRentalEntity bikeRentalEntity = new BikeRentalEntity();
        bikeRentalEntity.setId(bikeRentalPojo.getId());
        bikeRentalEntity.setBikeBrand(bikeRentalPojo.getBikeBrand());
        bikeRentalEntity.setSeat(bikeRentalPojo.getSeat());
        bikeRentalEntity.setPrice(bikeRentalPojo.getPrice());

        if (bikeRentalPojo.getBikeImage() != null) {
            Path fileSavePath = Paths.get(UPLOAD_DIRECTORY, bikeRentalPojo.getBikeImage().getOriginalFilename());
            Files.createDirectories(fileSavePath.getParent()); // Create the directory if it doesn't exist
            Files.write(fileSavePath, bikeRentalPojo.getBikeImage().getBytes());
            bikeRentalEntity.setBikeImage(bikeRentalPojo.getBikeImage().getOriginalFilename());
        }

        bikeRentalRepository.save(bikeRentalEntity);
    }

    @Override
    public void updateBike(BikeRentalPojo bikeRentalPojo) throws IOException {
        Optional<BikeRentalEntity> optionalBikeRentalEntity = bikeRentalRepository.findById(bikeRentalPojo.getId());

        if (optionalBikeRentalEntity.isPresent()) {
            BikeRentalEntity bikeRentalEntity = optionalBikeRentalEntity.get();
            bikeRentalEntity.setBikeBrand(bikeRentalPojo.getBikeBrand());
            bikeRentalEntity.setSeat(bikeRentalPojo.getSeat());
            bikeRentalEntity.setPrice(bikeRentalPojo.getPrice());

            if (bikeRentalPojo.getBikeImage() != null) {
                Path fileSavePath = Paths.get(UPLOAD_DIRECTORY, bikeRentalPojo.getBikeImage().getOriginalFilename());
                Files.createDirectories(fileSavePath.getParent()); // Create the directory if it doesn't exist
                Files.write(fileSavePath, bikeRentalPojo.getBikeImage().getBytes());
                bikeRentalEntity.setBikeImage(bikeRentalPojo.getBikeImage().getOriginalFilename());
            }

            bikeRentalRepository.save(bikeRentalEntity);
        } else {
            throw new IllegalArgumentException("Bike rental with ID " + bikeRentalPojo.getId() + " not found");
        }
    }

    @Override
    public List<BikeRentalEntity> getAllBikeRentals() {
        ImageToBase64Bike imageToBase64Bike = new ImageToBase64Bike(); // Ensure this utility exists
        List<BikeRentalEntity> bikeRentalEntities = bikeRentalRepository.findAll();
        bikeRentalEntities = bikeRentalEntities.stream().map(bike -> {
            bike.setBikeImage(imageToBase64Bike.getImageBase64(bike.getBikeImage()));
            return bike;
        }).collect(Collectors.toList());
        return bikeRentalEntities;
    }

    @Override
    public Optional<BikeRentalEntity> getBikeRentalById(Integer id) {
        return bikeRentalRepository.findById(id);
    }

    @Override
    public void deleteBikeRental(Integer id) {
        bikeRentalRepository.deleteById(id);
    }
}
