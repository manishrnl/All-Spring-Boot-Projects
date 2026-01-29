package org.example.tutorial_2_homework.hospital_management_system;

import org.example.tutorial_2_homework.hospital_management_system.entity.Appointment;
import org.example.tutorial_2_homework.hospital_management_system.repository.AppointmentRepository;
import org.example.tutorial_2_homework.hospital_management_system.service.AppointmentService;
import org.example.tutorial_2_homework.hospital_management_system.service.AppointmentService2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private AppointmentService2 appointmentService2;
    @Autowired
    private AppointmentService appointmentService;

    /*
    Above Autowiring is similar as
    private final AppointmentRepository appointmentRepository;
    private final AppointmentService2 appointmentService2;
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentTest(AppointmentRepository appointmentRepository,
                           AppointmentService2 appointmentService2,
                           AppointmentService appointmentService) {
        this.appointmentRepository = appointmentRepository;
        this.appointmentService2 = appointmentService2;
        this.appointmentService = appointmentService;
    }

     */
    @Test
    public void test1() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 5, 20, 14, 30))
                .reason("Regular Checkup")
                .build();
        appointmentService.createAppointment(appointment, 1L, 4L);
        appointmentRepository.save(appointment);

        System.out.println("Appointments Saved with ids as  : " + appointment.getId());
    }

    @Test
    public void test3() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 5, 5, 1, 15, 15))
                .reason("Heart Attack")
                .build();
        appointmentService2.setAppointment(appointment, 3L, 1L);
        appointmentRepository.save(appointment);

    }
}
