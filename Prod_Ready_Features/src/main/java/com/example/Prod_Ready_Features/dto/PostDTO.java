package com.example.Prod_Ready_Features.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private Long id;
    private String title;
    private String description;
}
