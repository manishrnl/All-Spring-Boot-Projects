package org.example.tutorial_2_homework.hospital_management_system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.hospital_management_system.entity.*;
import org.example.tutorial_2_homework.hospital_management_system.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    @Transactional
    public Appointment createAppointment(Appointment appointment, Long patientId,
                                         Long doctorId) {

        Optional<Patient> patient = patientRepository.findById(patientId);
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if (patient.isEmpty()) {
            System.out.println("Unable to find patient with ids: " + patientId);
            return null;
        }
        if (doctor.isEmpty()) {
            System.out.println("Could not find Doctor with ids: " + doctorId);
            return null;
        }

        appointment.setPatient(patient.get());
        appointment.setDoctor(doctor.get());

        appointmentRepository.save(appointment);
        System.out.println("Saved Successfully into our database");
        return appointment;
    }

}

