package org.example.bikerental.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.bikerental.entity.RegistrationEntity;
import org.example.bikerental.pojo.RegistrationPojo;
import org.example.bikerental.repository.RegistrationRepository;
import org.example.bikerental.service.RegistrationService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;

    @Override
    public void saveData(RegistrationPojo registrationPojo) {
        if (registrationRepository.findByEmail(registrationPojo.getEmail()) != null) {
            throw new IllegalArgumentException("Email already exists");
        }

        RegistrationEntity registration = new RegistrationEntity();
        registration.setId(registrationPojo.getId());
        registration.setUsername(registrationPojo.getUsername());
        registration.setPassword(registrationPojo.getPassword()); // No encryption
        registration.setFullName(registrationPojo.getFull_name());
        registration.setEmail(registrationPojo.getEmail());
        registration.setContactUs(registrationPojo.getContact_us());
        registrationRepository.save(registration);
    }

    @Override
    public RegistrationPojo findUserByEmail(String email) {
        RegistrationEntity entity = registrationRepository.findByEmail(email);
        if (entity != null) {
            RegistrationPojo pojo = new RegistrationPojo();
            BeanUtils.copyProperties(entity, pojo);
            return pojo;
        }
        return null;
    }

    @Override
    public boolean authenticateUser(String email, String password) {
        RegistrationEntity user = registrationRepository.findByEmail(email);
        return user != null && password.equals(user.getPassword()); // No password verification with encoder
    }

    @Override
    public List<RegistrationEntity> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @Override
    public Optional<RegistrationEntity> getRegistrationsById(Integer id) {
        return registrationRepository.findById(id);
    }

    @Override
    public void deleteRegistration(Integer id) {
        registrationRepository.deleteById(id);
    }
}
