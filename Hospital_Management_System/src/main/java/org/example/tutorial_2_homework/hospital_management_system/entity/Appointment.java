package org.example.tutorial_2_homework.hospital_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne // owning side
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    @JsonIgnore
    private Doctor doctor;
}

/*
CREATE TABLE Appointment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    appointment_time DATETIME NOT NULL,
    reason VARCHAR(500),
    patient_id BIGINT NOT NULL,
    doctor_id BIGINT NOT NULL,
    CONSTRAINT FK_Appointment_Patient FOREIGN KEY (patient_id) REFERENCES Patient(id),
    CONSTRAINT FK_Appointment_Doctor FOREIGN KEY (doctor_id) REFERENCES Doctor(id)
);

 */