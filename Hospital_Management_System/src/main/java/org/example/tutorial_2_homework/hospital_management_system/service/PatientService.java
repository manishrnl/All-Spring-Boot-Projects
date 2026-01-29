package org.example.tutorial_2_homework.hospital_management_system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.hospital_management_system.entity.Doctor;
import org.example.tutorial_2_homework.hospital_management_system.entity.Patient;
import org.example.tutorial_2_homework.hospital_management_system.repository.DoctorRepository;
import org.example.tutorial_2_homework.hospital_management_system.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public void testPatientTransaction(Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Patient patient2 = patientRepository.findById(patientId).orElseThrow();
        System.out.println("Is p1 == p2 " + (patient2 == patient));


    }

    @Transactional
    public void deletePatients(Long patientId) {
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isPresent()) {
            patientRepository.deleteById(patientId);
            System.out.println("************************** \n\n\n\n\nPatient with IDs : " + patientId +
                    " deleted Successfully.");
            return;
        } else
            System.out.println("*******************\n\n\n\nCould not found patients with " +
                    "ids = "+patientId);

    }

}
