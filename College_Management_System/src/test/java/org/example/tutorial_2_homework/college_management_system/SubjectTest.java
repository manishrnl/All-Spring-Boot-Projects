package org.example.tutorial_2_homework.college_management_system;

import org.example.tutorial_2_homework.college_management_system.entity.Subject;
import org.example.tutorial_2_homework.college_management_system.service.SubjectService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SubjectTest {


    @Autowired
    private SubjectService subjectService;

    @Test
    public void createNewSubjects() {

        Subject subject = Subject.builder()
                .subjectTitle("Maths")
                .subjectCode("MTH101")
                .build();
        subjectService.createNewSubject(subject);
    }

}
