package org.example.tutorial_2_homework.spring_boot_web.repositories;

import org.example.tutorial_2_homework.spring_boot_web.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
