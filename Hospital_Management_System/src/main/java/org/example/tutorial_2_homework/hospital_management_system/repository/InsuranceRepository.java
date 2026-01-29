package org.example.tutorial_2_homework.hospital_management_system.repository;

import org.example.tutorial_2_homework.hospital_management_system.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
