package org.example.bikerental.service.impl;

import lombok.RequiredArgsConstructor;

import org.example.bikerental.entity.RegistrationEntity;
import org.example.bikerental.repository.LoginRepository;
import org.example.bikerental.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Override
    public boolean authenticateUser(String email, String password) {
        RegistrationEntity user = loginRepository.findByEmail(email);
        return user != null && user.getPassword().equals(password);
    }
}
