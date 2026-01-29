package org.example.tutorial_2_homework.college_management_system.service;

import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.college_management_system.entity.Professor;
import org.example.tutorial_2_homework.college_management_system.repository.ProfessorRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ProfessorService {

    private final ProfessorRepository professorRepository;

    public void createProfessor(Professor professor) {
        professorRepository.save(professor);
    }

}