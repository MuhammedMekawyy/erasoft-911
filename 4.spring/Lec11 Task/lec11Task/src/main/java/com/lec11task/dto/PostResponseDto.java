package com.lec11task.dto;

import lombok.Data;

@Data
public class PostResponseDto {
    private Long id;
    private String text;
    private String imagePath;
    private Long userId;
}