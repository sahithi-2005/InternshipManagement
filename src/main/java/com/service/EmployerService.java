package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.Employer;
import com.repository.EmployerRepository;

@Service
public class EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    public Employer findEmployerByEmailAndPassword(String email, String password) {
        return employerRepository.findByEmailAndPassword(email, password);
    }
}
