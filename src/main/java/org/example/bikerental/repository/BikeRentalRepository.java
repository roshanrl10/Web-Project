package org.example.bikerental.repository;

import org.example.bikerental.entity.BikeRentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRentalRepository extends JpaRepository<BikeRentalEntity, Integer> {
}
