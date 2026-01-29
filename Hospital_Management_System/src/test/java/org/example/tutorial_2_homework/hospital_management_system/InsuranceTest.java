package org.example.tutorial_2_homework.hospital_management_system;

import org.example.tutorial_2_homework.hospital_management_system.entity.Insurance;
import org.example.tutorial_2_homework.hospital_management_system.repository.InsuranceRepository;
import org.example.tutorial_2_homework.hospital_management_system.repository.PatientRepository;
import org.example.tutorial_2_homework.hospital_management_system.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void addsInsurance_Patient() {
        Insurance insurance = Insurance.builder()
                .provider("Bajaj Allianz")
                .policyNumber("BA123456")
                .validUntil(LocalDate.parse("2023-01-01"))
                .build();
        insuranceService.setInsuranceToPatient(insurance, 2L);
        insuranceRepository.save(insurance);

        System.out.println("**************************** \n \n\n\nSuccessfully added new " +
                "insurance to Patient : 2");

    }


}
