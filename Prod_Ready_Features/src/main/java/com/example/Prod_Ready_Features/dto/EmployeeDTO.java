package com.example.Prod_Ready_Features.dto;

import jakarta.validation.constraints.AssertTrue;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class EmployeeDTO {

    private Long id;
    private String name;
    private String email;

    private Integer age;
    private LocalDate dateOfJoining;
    @AssertTrue(message = "isActive Could not be set to False")
    private Boolean isActive;
    private String role;
    private Double salary;

}
