package org.example.tutorial_2_homework.college_management_system;

import org.example.tutorial_2_homework.college_management_system.entity.AdmissionRecord;
import org.example.tutorial_2_homework.college_management_system.service.AdmissionRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdmissionRecordTest {

    @Autowired
    private AdmissionRecordService admissionRecordService;

    @Test
    public void testCreateAdmissionRecord() {
        AdmissionRecord admissionRecord = AdmissionRecord.builder()
                .fees(5000)
                .enrollmentNumber("ENR123456")
                .build();

        admissionRecordService.createAdmissionRecord(admissionRecord);
    }

    @Test
    public void setAdmissionRecordToStudents() {
        admissionRecordService.setAdmissionRecordToStudents(2L, 3L);
        admissionRecordService.setAdmissionRecordToStudents(3L, 5L);

    }
}
