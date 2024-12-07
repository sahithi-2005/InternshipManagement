package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.model.Employer;

public interface EmployerRepository extends JpaRepository<Employer, Long> {
    Employer findByEmailAndPassword(String email, String password);
}
