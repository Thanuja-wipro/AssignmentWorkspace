package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repo.PatientRepository;
import com.example.demo.service.IPatientService;

@RestController
@RequestMapping("/api/patient") // http://localhost:6200/api/patient
public class PatientController {

	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private PatientRepository patientRepo;
	
	// http://localhost:6200/api/patient/hello
	@GetMapping("/hello")
	String hello() {
		return "Hello World, Spring Boot.... Welcome to You!";
	}
	

	//@GetMapping(path = "/orders", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/patients") // http://localhost:6200/api/patient/patients
	 List<Patient> getAllPatients() {
		return patientService.getPatientsFromDatabase();
	}

	// http://localhost:6200/api/patient/patients/{id}
	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatientById(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Patient> patient = patientService.getPatientById(id);
		patient.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id));
		return patient;
	}

	@DeleteMapping("/patients/{id}")
	public void deletePatientById(@PathVariable int id) {
		patientService.deletePatientById(id);
	}

	@PostMapping("/patients")
	public Patient createPatient(@Validated @RequestBody Patient newPatient) {
		return patientService.createPatient(newPatient);
	}

	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable(value = "id") Integer patientId,
			@Validated @RequestBody Patient newPatient) {
		return patientService.updatePatient(patientId, newPatient);
	}
	
	//	for Feign
	// http://localhost:6200/api/patient/patient/doctor/1
		@GetMapping("/patient/doctor/{doctorId}")
		public List<Patient> getPatientByDoctor(@PathVariable int doctorId) {
	        return patientRepo.getByDoctorID(doctorId);
		}
		
		// http://localhost:6200/api/patient/patient/req?id=1
		@GetMapping("/patient/req")
		Optional<Patient> findByPatientIdUsingRequest(@RequestParam int id) {
			
			return patientService.getPatientById(id);
		}
	

}
