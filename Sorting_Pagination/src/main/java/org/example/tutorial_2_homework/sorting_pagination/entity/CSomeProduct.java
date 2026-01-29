package org.example.tutorial_2_homework.sorting_pagination.entity;

import jakarta.persistence.SecondaryTable;
import lombok.Data;

import java.math.BigDecimal;
import java.text.DecimalFormat;

@Data

public class CSomeProduct {
    private final Long id;
    private final String description;
    private final BigDecimal oldPrice;

}
