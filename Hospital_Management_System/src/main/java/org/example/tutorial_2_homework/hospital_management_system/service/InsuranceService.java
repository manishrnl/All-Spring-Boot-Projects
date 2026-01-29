package org.example.tutorial_2_homework.hospital_management_system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.hospital_management_system.entity.Insurance;
import org.example.tutorial_2_homework.hospital_management_system.entity.Patient;
import org.example.tutorial_2_homework.hospital_management_system.repository.InsuranceRepository;
import org.example.tutorial_2_homework.hospital_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
// This annotation generates a constructor with required arguments (final fields)
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional //Without this annotation, the insurance won't be saved to the database
    // as all have different memory address in Heap and JPA won't be able to recognize the
    // relationship
    public void setInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patient.setInsurance(insurance);
        insurance.setPatient(patient); // Set the patient in the insurance entity to
        // maintain bidirectional relationship, so that whenever we want to fetch or update
        // inside this functions for patient entity, we can do it easily

    }

}
