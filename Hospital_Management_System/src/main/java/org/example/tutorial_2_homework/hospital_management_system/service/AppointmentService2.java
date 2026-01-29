package org.example.tutorial_2_homework.hospital_management_system.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.hospital_management_system.entity.Appointment;
import org.example.tutorial_2_homework.hospital_management_system.entity.Doctor;
import org.example.tutorial_2_homework.hospital_management_system.entity.Patient;
import org.example.tutorial_2_homework.hospital_management_system.repository.AppointmentRepository;
import org.example.tutorial_2_homework.hospital_management_system.repository.DoctorRepository;
import org.example.tutorial_2_homework.hospital_management_system.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentService2 {

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;


    @Transactional
    public Appointment setAppointment(Appointment appointment, Long patientId, Long doctorId) {

        Optional<Patient> patient = patientRepository.findById(patientId);
        Optional<Doctor> doctor = doctorRepository.findById(doctorId);

        if (!patient.isPresent()) {
            System.out.println("Unable to fetch patient with ids " + patientId);
            return null;
        }
        if (!doctor.isPresent()) {
            System.out.println("Unbale to fetch doctor with ids :" + doctorId);
            return null;
        }

        appointment.setPatient(patient.get());
        appointment.setDoctor(doctor.get());

        appointmentRepository.save(appointment);
        System.out.println("Appointments Saved Successfully");
        return appointment;
    }
}
