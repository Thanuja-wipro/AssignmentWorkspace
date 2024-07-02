package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Patient;

public interface IPatientService {

	List<Patient> getPatientsFromDatabase();

	Optional<Patient> getPatientById(int id);

	void deletePatientById(int id);

	Patient createPatient(Patient newPatient);

	ResponseEntity<Patient> updatePatient(Integer patientId, Patient newPatient);
}
