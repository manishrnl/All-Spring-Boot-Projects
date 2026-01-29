package com.example.tutorial_23.dto;

import com.example.tutorial_23.annotations.RoleValidation;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

//@Service      //Do not Annotate it with @Service or anything else because it is not a Bean
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name is Required")
    private String name;

    @NotNull(message = "Age is Required")
    @Min(value = 18, message = "Minimum Age should be 18")
    @Max(value = 100, message = "Maximum age should not be greater than be 100")
    private int age;

    @NotNull(message = "Email is Required")
    @Email(message = "Email must be of correct pattern")
    private String email;

    private String city;

    @NotNull(message = "Role is Required")
    @RoleValidation
    private String role;

    private long mobile;
    private Boolean isActive;

    //    @PastOrPresent(message = "Date of joining should be till tomorrow or in the past . It " +
//            "should not be in the future")
    @CreationTimestamp
    @JsonFormat(pattern = "EEEE MMMM dd yyyy hh:mm:ss a", timezone = "Asia/Kolkata")
    private LocalDate dateOfJoining;

}


