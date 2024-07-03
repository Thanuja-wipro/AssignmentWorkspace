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

import com.example.demo.cts.PatientFeignClient;
import com.example.demo.entity.Doctor;
import com.example.demo.entity.Patient;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.service.IDoctorService;

@RestController
@RequestMapping("/api/doctor") // http://localhost:6100/api/doctor
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	PatientFeignClient patientClient;

	// http://localhost:6100/api/doctor/hello
	@GetMapping("/hello")
	String hello() {
		return "Hello World, Spring Boot.... Welcome to You!";
	}
	

	//@GetMapping(path = "/doctors", produces = {MediaType.APPLICATION_XML_VALUE})
	@GetMapping("/doctors") // http://localhost:6100/api/doctor/doctors
	 List<Doctor> getAllDoctors() {
		return doctorService.getDoctorsFromDatabase();
	}
	
	//http://localhost:6100/api/doctor/doctors/{id}
	@GetMapping("/doctors/{id}")
	public Optional<Doctor> getDoctorById(@PathVariable int id) throws ResourceNotFoundException {
		Optional<Doctor> order = doctorService.getDoctorById(id);
		order.orElseThrow(() -> new ResourceNotFoundException("Doctor not found for this id :: " + id));
		return order;
	}

	@DeleteMapping("/doctors/{id}")
	public void deleteDoctorById(@PathVariable int id) {
		doctorService.deleteDoctorById(id);
	}

	@PostMapping("/doctors")
	public Doctor createDoctor(@Validated @RequestBody Doctor newDoctor) {
		return doctorService.createDoctor(newDoctor);
	}

	@PutMapping("/doctors/{id}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id") Integer doctorId,
			@Validated @RequestBody Doctor newDoctor) {
		return doctorService.updateDoctor(doctorId, newDoctor);
	}
	
	//feign call
		//http://localhost:6100/api/doctor/1/patient
		@GetMapping("/{doctorId}/patient")
		public List<Patient> getPatientsByDoctor(@PathVariable long doctorId) {
	        return patientClient.getPatientByDoctorId(doctorId);
		}

		//http://localhost:6100/api/doctor/doctors/req?id=1
		@GetMapping("/doctors/req")
		Optional<Doctor> findByDoctorIdUsingRequest(@RequestParam int id) {
			return doctorService.getDoctorById(id);
		}
		
	


}