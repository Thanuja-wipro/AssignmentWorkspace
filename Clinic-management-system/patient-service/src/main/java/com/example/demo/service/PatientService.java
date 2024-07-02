package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.demo.entity.Patient;
import com.example.demo.repo.PatientRepository;

@Service
public class PatientService implements IPatientService {

	private final Logger logger = LoggerFactory.getLogger(PatientService.class);

	@Autowired
	PatientRepository patientRepo;

	@Override
	public List<Patient> getPatientsFromDatabase() {
		logger.info("Fetching all patients...");
		return patientRepo.findAll();
	}

	@Override
	public Optional<Patient> getPatientById(int id) {
		return patientRepo.findById(id);
	}

	@Override
	public void deletePatientById(int id) {
		patientRepo.deleteById(id);
	}

	@Override
	public Patient createPatient(@Validated Patient newPatient) {
		return patientRepo.save(newPatient);
	}

	@Override
	public ResponseEntity<Patient> updatePatient(Integer patientId, @Validated Patient newPatient) {
		Optional<Patient> existingPatient = patientRepo.findById(patientId);
		existingPatient.ifPresent(patient -> {
			patient.setPatientName(newPatient.getPatientName());
			patientRepo.save(patient);
		});
		return ResponseEntity.of(existingPatient);
	}
}
