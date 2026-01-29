package org.example.tutorial_2_homework.college_management_system.service;

import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.college_management_system.entity.AdmissionRecord;
import org.example.tutorial_2_homework.college_management_system.entity.Student;
import org.example.tutorial_2_homework.college_management_system.repository.AdmissionRecordRepository;
import org.example.tutorial_2_homework.college_management_system.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdmissionRecordService {

    private final AdmissionRecordRepository admissionRecordRepository;
    private final StudentRepository studentRepository;


    public void createAdmissionRecord(AdmissionRecord admissionRecord) {
        admissionRecordRepository.save(admissionRecord);
        System.out.println("Successfully created admission record: ");
        // Logic to create an admission record
    }

    public void setAdmissionRecordToStudents(long studentId, long admissionRecordId) {
        System.out.println("Initiating setting admission record to student...");

        Optional<AdmissionRecord> admissionRecordOpt = admissionRecordRepository.findById(admissionRecordId);
        Optional<Student> studentOpt = studentRepository.findById(studentId);

        if (admissionRecordOpt.isEmpty() || studentOpt.isEmpty()) {
            System.out.println("Either admission record or student not found.");

        } else {

            AdmissionRecord admissionRecord = admissionRecordOpt.get();

            Student student = studentOpt.get();

            admissionRecord.setStudent(student);
            admissionRecordRepository.save(admissionRecord);
            System.out.println("Saved Admission Records to Student successfully.");
        }
    }
}
