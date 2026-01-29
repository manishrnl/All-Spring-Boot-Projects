package com.example.JPA_Tutorial.entities;

import lombok.Data;

@Data
public class CSomeProduct {
    private final Long id;
    private final String title;
    private final String sku;
}
