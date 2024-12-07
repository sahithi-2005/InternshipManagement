package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.model.PlacementOfficer;

public interface PlacementOfficerRepository extends JpaRepository<PlacementOfficer, Long> {
    PlacementOfficer findByEmailAndPassword(String email, String password);
}