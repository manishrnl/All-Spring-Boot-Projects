package org.example.tutorial_2_homework.college_management_system.service;

import org.example.tutorial_2_homework.college_management_system.entity.Subject;
import org.example.tutorial_2_homework.college_management_system.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void createNewSubject(Subject subject) {

        subjectRepository.save(subject);
        System.out.println("New subject created: ");


    }
}
