package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Patient;

import feign.Param;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	@Query(value = "select p from Patient p where p.doc_id = :docId")
	List<Patient> getByDoctorID(@Param("docId") int docId);
//	@Query(nativeQuery = true, value = "select * from patient where doc_id = 1")
//	List<Patient> findByDoctorID();
}
