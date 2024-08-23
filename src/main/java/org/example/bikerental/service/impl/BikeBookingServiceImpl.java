package org.example.bikerental.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.bikerental.entity.BikeBookingEntity;
import org.example.bikerental.entity.BikeRentalEntity;
import org.example.bikerental.entity.RegistrationEntity;
import org.example.bikerental.pojo.BikeBookingPojo;
import org.example.bikerental.repository.BikeBookingRepository;
import org.example.bikerental.repository.BikeRentalRepository;
import org.example.bikerental.repository.RegistrationRepository;
import org.example.bikerental.service.BikeBookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BikeBookingServiceImpl implements BikeBookingService {

    private final BikeBookingRepository bikeBookingRepository;
    private final BikeRentalRepository bikeRentalRepository;
    private final RegistrationRepository registrationRepository;

    @Override
    public void saveBikeBooking(BikeBookingPojo bikeBookingPojo) {
        BikeBookingEntity bikeBookingEntity = new BikeBookingEntity();
        BikeRentalEntity bikeRentalEntity = bikeRentalRepository.findById(bikeBookingPojo.getBikeId()).orElse(null);
        RegistrationEntity registrationEntity = registrationRepository.findById(bikeBookingPojo.getUserId())
                .orElse(null);
        bikeBookingEntity.setTotalAmount(bikeBookingPojo.getTotalAmount());

        if (bikeRentalEntity != null && registrationEntity != null) {
            bikeBookingEntity.setBike_Adding(bikeRentalEntity);
            bikeBookingEntity.setRegistration(registrationEntity);
        }
        bikeBookingEntity.setRentalStartdateTime(bikeBookingPojo.getRentalStartdateTime());
        bikeBookingEntity.setRentalEnddateTime(bikeBookingPojo.getRentalEnddateTime());

        bikeBookingRepository.save(bikeBookingEntity);
    }

    @Override
    public List<BikeBookingEntity> getAllBikeBookings() {
        return bikeBookingRepository.findAll();
    }

    @Override
    public Optional<BikeBookingEntity> getBikeBookingById(Integer id) {
        return bikeBookingRepository.findById(id);
    }

    @Override
    public void deleteBikeBooking(Integer id) {
        bikeBookingRepository.deleteById(id);
    }
}
