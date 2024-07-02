package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	// You can add custom query methods if needed
}