package org.example.tutorial_2_homework.hospital_management_system.entity.enums;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class BloodGroupConverter implements AttributeConverter<BloodGroup, String> {

    @Override
    public String convertToDatabaseColumn(BloodGroup attribute) {
        if (attribute == null) return null;
        return attribute.getValue(); // Store as A+, B-, etc.
    }

    @Override
    public BloodGroup convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return BloodGroup.fromValue(dbData);
    }
}

