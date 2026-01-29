package org.example.tutorial_2_homework.hospital_management_system.repository;

import org.example.tutorial_2_homework.hospital_management_system.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}