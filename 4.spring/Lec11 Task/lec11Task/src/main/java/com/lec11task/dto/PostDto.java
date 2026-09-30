package com.lec11task.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PostDto {   // request body

    @NotNull(message = "Text is required")
    @Size(min = 20, message = "Text must be at least 20 characters")
    private String text;

    private String imagePath;

    private Long userId;   // optional
}
