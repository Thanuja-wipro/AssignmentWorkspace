package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Doctor;

public interface IDoctorService {

	List<Doctor> getDoctorsFromDatabase();

	Optional<Doctor> getDoctorById(int id);

	void deleteDoctorById(int id);

	Doctor createDoctor(Doctor newDoctor);

	ResponseEntity<Doctor> updateDoctor(Integer doctorId, Doctor newDoctor);
}
