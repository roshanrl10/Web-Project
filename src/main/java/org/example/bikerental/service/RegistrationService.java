package org.example.bikerental.service;

import java.util.List;
import java.util.Optional;

import org.example.bikerental.entity.RegistrationEntity;
import org.example.bikerental.pojo.RegistrationPojo;

public interface RegistrationService {
    void saveData(RegistrationPojo registrationPojo);

    RegistrationPojo findUserByEmail(String email);

    boolean authenticateUser(String email, String password);

    List<RegistrationEntity> getAllRegistrations();

    Optional<RegistrationEntity> getRegistrationsById(Integer id);

    void deleteRegistration(Integer id);
}
