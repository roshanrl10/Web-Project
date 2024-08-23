package org.example.bikerental.repository;

import org.example.bikerental.entity.BikeBookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeBookingRepository extends JpaRepository<BikeBookingEntity, Integer> {

}
