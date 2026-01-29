package org.example.tutorial_2_homework.hospital_management_system.repository;

import org.example.tutorial_2_homework.hospital_management_system.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}