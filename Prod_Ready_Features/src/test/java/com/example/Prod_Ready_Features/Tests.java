package com.example.Prod_Ready_Features;

import com.example.Prod_Ready_Features.clients.EmployeeClient;
import com.example.Prod_Ready_Features.dto.EmployeeDTO;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class Tests {
    @Autowired
    private EmployeeClient employeeClient;

    @Test
    @Order(3)
    void getAllEmployees() {
        List<EmployeeDTO> studentList = employeeClient.getAllEmployees();
        System.out.println(studentList);


    }

    @Test
    @Order(2)
    public void getEmployeeById() {
        EmployeeDTO employeeDTO = employeeClient.getEmployeeById(2L);
        System.out.println(employeeDTO);

    }

    @Test
    @Order(1)
    public void createNewEmployee() {
        EmployeeDTO data = new EmployeeDTO();
        data = data.builder()
                .name("Manish Kumar Sahu")
                .age(2)
                .email("Email.com")
                .id(null)
                .role("Roles")
                .salary(5000.00)
                .dateOfJoining(LocalDate.from(LocalDateTime.now()))
                .isActive(false)
                .build();

        EmployeeDTO employeeDTO = employeeClient.createNewEmployee(data);
    }
}
