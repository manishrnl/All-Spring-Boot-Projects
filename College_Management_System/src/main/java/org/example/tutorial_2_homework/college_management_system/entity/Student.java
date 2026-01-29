package org.example.tutorial_2_homework.college_management_system.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private Long phoneNumber;
    private String address;
    private String course;

    // Many students belong to one professor
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "professor_id")
    private Professor professor;

    // Many students belong to one subject
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    // One student has many admission records
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AdmissionRecord> admissionRecords;




    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "student")
    private List<Professor> professor;

    @ManyToMany(mappedBy = "student")
    private List<Subject> subject;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private AdmissionRecord admissionRecord;

    */
}
