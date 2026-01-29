package org.example.tutorial_2_homework.hospital_management_system;

import lombok.RequiredArgsConstructor;
import org.example.tutorial_2_homework.hospital_management_system.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.AutoConfigureDataElasticsearch;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor

public class PatientTest {
    @Autowired
    private PatientService patientService;

    @Test
    public void test1() {
        patientService.testPatientTransaction(2L);

    }

    @Test
    public void test2() {
        patientService.deletePatients(2L);
        patientService.deletePatients(2L);
        patientService.deletePatients(3L);
        patientService.deletePatients(3L);
    }

}
