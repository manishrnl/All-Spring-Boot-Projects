package org.example.tutorial_2_homework.college_management_system.repository;

import org.example.tutorial_2_homework.college_management_system.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
