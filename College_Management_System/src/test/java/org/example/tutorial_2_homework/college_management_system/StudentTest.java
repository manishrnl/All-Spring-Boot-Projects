package org.example.tutorial_2_homework.college_management_system;

import org.example.tutorial_2_homework.college_management_system.entity.AdmissionRecord;
import org.example.tutorial_2_homework.college_management_system.entity.Student;
import org.example.tutorial_2_homework.college_management_system.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class StudentTest {
    @Autowired
    private StudentService studentService;

    @Test
    public void createNewStudents() {

        Student student = Student.builder()
                .name("Manisha Kumari")
                .email("manishrajrnl@zohomail.in")
                .course("B.tech")
                .address("India")
                .phoneNumber(9876543210L)
                .subject(null)
                .professor(null)
                .build();
        studentService.createNewStudent(student);
    }


    @Test
    public void assignStudentWithAllData() {
        studentService.assignStudentWithAllData(2L, 5L, 4L);

    }

    @Test
    public void getStudentsByEnrollId() {

       studentService.getStudentsByEnrollId("ENR1005");
    }
}
