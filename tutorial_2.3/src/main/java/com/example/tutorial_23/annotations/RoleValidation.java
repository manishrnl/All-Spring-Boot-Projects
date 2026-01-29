package com.example.tutorial_23.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(
        validatedBy = {RoleValidator.class}
)
public @interface RoleValidation {
    String message() default "Roles Could either be Users or Admin";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
