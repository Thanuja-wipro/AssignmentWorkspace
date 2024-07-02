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
import com.example.demo.service.IPatientService;

@RestController
@RequestMapping("/api/patient") // http://localhost:9191/api/hello
public class PatientController {

	@Autowired
	private IPatientService doctorService;
	
//	@Autowired
//	DoctorFeignClient dFeignClient;

	@GetMapping("/hello")
	String hello() {
		return "Hello World, Spring Boot.... Welcome to You!";
	}
	

	//@GetMapping(path = "/orders", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/patients") // http://localhost:9191/api/orders
	 List<Patient> getAllDoctors() {
		return doctorService.getPatientsFromDatabase();
	}

	@GetMapping("/patients/{id}")
	public Optional<Patient> getPatientById(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Patient> patient = doctorService.getPatientById(id);
		patient.orElseThrow(() -> new ResourceNotFoundException("Patient not found for this id :: " + id));
		return patient;
	}

	@DeleteMapping("/patients/{id}")
	public void deleteDoctorById(@PathVariable int id) {
		doctorService.deletePatientById(id);
	}

	@PostMapping("/patients")
	public Patient createDoctor(@Validated @RequestBody Patient newOrder) {
		return doctorService.createPatient(newOrder);
	}

	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updateDoctor(@PathVariable(value = "id") Integer orderId,
			@Validated @RequestBody Patient newOrder) {
		return doctorService.updatePatient(orderId, newOrder);
	}

	@GetMapping("/patients/req")
	public Optional<Patient> findDoctorByOrderIdUsingRequestParam(@RequestParam int id) {
		return doctorService.getPatientById(id);
	}
	

}
