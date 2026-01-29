package com.example.tutorial_23.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class RoleValidator implements ConstraintValidator<RoleValidation, String> {

    @Override
    public boolean isValid(String inputRole,
                           ConstraintValidatorContext constraintValidatorContext) {
        List<String> roles = List.of("Users", "Admin");

        return roles.contains(inputRole);
    }
}
