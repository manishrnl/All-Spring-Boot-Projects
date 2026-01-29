package org.example.tutorial_2_homework.hospital_management_system.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    @JoinColumn(nullable = false)
    private Doctor headDoctor;

    @ManyToMany
    private Set<Doctor> doctors = new HashSet<>();

}

/*

CREATE TABLE Department (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    head_doctor_id BIGINT NOT NULL,
    CONSTRAINT FK_Department_HeadDoctor FOREIGN KEY (head_doctor_id) REFERENCES Doctor(id)
);

CREATE TABLE Department_Doctors (
    department_id BIGINT NOT NULL,
    doctors_id BIGINT NOT NULL,
    PRIMARY KEY (department_id, doctors_id),
    CONSTRAINT FK_DepartmentDoctors_Department FOREIGN KEY (department_id) REFERENCES Department(id),
    CONSTRAINT FK_DepartmentDoctors_Doctor FOREIGN KEY (doctors_id) REFERENCES Doctor(id)
);

 */
