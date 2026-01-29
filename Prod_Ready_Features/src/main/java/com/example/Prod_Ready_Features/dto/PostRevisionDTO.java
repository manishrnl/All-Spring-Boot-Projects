package com.example.Prod_Ready_Features.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PostRevisionDTO {
    @Schema(description = "Post ID")
    private Long id;

    @Schema(description = "Post title")
    private String title;

    @Schema(description = "Post content")
    private String content;

    @Schema(description = "Revision number")
    private int revisionNumber;
}


