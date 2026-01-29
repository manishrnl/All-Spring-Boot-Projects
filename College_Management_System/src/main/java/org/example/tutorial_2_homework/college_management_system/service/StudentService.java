package org.example.tutorial_2_homework.college_management_system.service;

import com.fasterxml.jackson.core.Base64Variant;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.college_management_system.entity.AdmissionRecord;
import org.example.tutorial_2_homework.college_management_system.entity.Professor;
import org.example.tutorial_2_homework.college_management_system.entity.Student;
import org.example.tutorial_2_homework.college_management_system.entity.Subject;
import org.example.tutorial_2_homework.college_management_system.repository.AdmissionRecordRepository;
import org.example.tutorial_2_homework.college_management_system.repository.ProfessorRepository;
import org.example.tutorial_2_homework.college_management_system.repository.StudentRepository;
import org.example.tutorial_2_homework.college_management_system.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;
    private final SubjectRepository subjectRepository;
    private final AdmissionRecordRepository admissionRecordRepository;

    public void createNewStudent(Student student) {
        Optional<Student> isSaved = Optional.of(studentRepository.save(student));
        System.out.println("New student created");
    }

    @Transactional
    public void assignStudentWithAllData(Long studentId,
                                         Long professorId, Long subjectId) {
        Optional<Student> studentOpt = studentRepository.findById(studentId);
        Optional<Professor> professorOpt = professorRepository.findById(professorId);
        Optional<Subject> subjectOpt = subjectRepository.findById(subjectId);

        if (studentOpt.isEmpty() || professorOpt.isEmpty() || subjectOpt.isEmpty()) {
            System.out.println("Could not find student, professor, or subject with the given IDs.");
        } else {
            Student student = studentOpt.get();
            Professor professor = professorOpt.get();
            Subject subject = subjectOpt.get();

            student.setProfessor(professor);
            student.setSubject(subject);
            studentRepository.save(student);


            System.out.println("*****************************************\n\n\nDone");
        }
    }

    public void getStudentsByEnrollId(String enrollmentNumber) {

        Optional<AdmissionRecord> admissionOpt = admissionRecordRepository.findByEnrollmentNumber(enrollmentNumber);

        if (admissionOpt.isPresent()) {
            AdmissionRecord adm = admissionOpt.get();
            System.out.println("We had fetched data successfully. Presenting all details :");
            System.out.println("Admission Id is " + adm.getId());

            Student student = adm.getStudent();
            System.out.println("Student Id is " + student.getId() + " Name is : " + student.getName() + " Email address is " + student.getEmail());
        }

    }


}
