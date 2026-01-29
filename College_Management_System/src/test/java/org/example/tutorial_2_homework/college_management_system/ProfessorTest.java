package org.example.tutorial_2_homework.college_management_system;

import org.example.tutorial_2_homework.college_management_system.entity.Professor;
import org.example.tutorial_2_homework.college_management_system.service.ProfessorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProfessorTest {

    @Autowired
    private ProfessorService professorService;

    @Test
    public void createNewProfessorTest() {
        Professor professor = Professor.builder()
                .name("Arindam Dutta")
                .department("Computer Science and Engineering")
                .specialization("Artificial Intelligence and Machine Learning")
                .email("arindamDutta@zohomail.in")
                .title("Assistant Professor")
                .build();

        professorService.createProfessor(professor);

    }


}
