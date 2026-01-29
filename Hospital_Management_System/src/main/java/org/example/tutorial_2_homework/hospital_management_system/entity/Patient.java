package org.example.tutorial_2_homework.hospital_management_system.entity;

import jakarta.persistence.*;

import org.example.tutorial_2_homework.hospital_management_system.entity.enums.BloodGroup;
import org.example.tutorial_2_homework.hospital_management_system.entity.enums.BloodGroupConverter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dateOfBirth;

    private String email;

    private String gender;


    @Convert(converter = BloodGroupConverter.class)
    private BloodGroup bloodGroup;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "insurance_id", unique = true, nullable = true)
    private Insurance insurance; // owning side

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    // inverse side
//    @ToString.Exclude
    private Set<Appointment> appointments = new HashSet<>();

}
/*
CREATE TABLE Patient (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    date_of_birth DATE,
    email VARCHAR(255),
    gender VARCHAR(255),
    blood_group VARCHAR(255),
    created_at DATETIME,
    insurance_id BIGINT UNIQUE,
    CONSTRAINT FK_Patient_Insurance FOREIGN KEY (insurance_id) REFERENCES Insurance(id)
);

 */
