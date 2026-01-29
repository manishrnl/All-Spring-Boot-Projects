package org.example.tutorial_2_homework.hospital_management_system.repository;

import org.example.tutorial_2_homework.hospital_management_system.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}