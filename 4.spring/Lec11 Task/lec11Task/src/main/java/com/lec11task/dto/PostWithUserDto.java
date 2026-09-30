package com.lec11task.dto;

import lombok.Data;

@Data
public class PostWithUserDto {
    private Long id;
    private String text;
    private String imagePath;
    private UserResponseDto user;
}
