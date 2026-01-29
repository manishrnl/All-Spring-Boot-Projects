package org.example.tutorial_2_homework.college_management_system.repository;

import org.example.tutorial_2_homework.college_management_system.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
}
