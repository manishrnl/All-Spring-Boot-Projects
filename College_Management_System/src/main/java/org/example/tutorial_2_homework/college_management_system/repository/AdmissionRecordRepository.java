package org.example.tutorial_2_homework.college_management_system.repository;

import org.example.tutorial_2_homework.college_management_system.entity.AdmissionRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AdmissionRecordRepository extends JpaRepository<AdmissionRecord, Long> {

    Optional<AdmissionRecord> findByEnrollmentNumber(String enrollmentNumber);


}
