package org.example.bikerental.repository;

import org.example.bikerental.entity.RegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<RegistrationEntity, Integer> {
    RegistrationEntity findByEmail(String email);
}
