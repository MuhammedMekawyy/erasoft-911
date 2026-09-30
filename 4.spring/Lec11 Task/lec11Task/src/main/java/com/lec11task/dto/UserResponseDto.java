package com.lec11task.dto;

import lombok.Data;

@Data
public class UserResponseDto {   // never returns the password
    private Long id;
    private String name;
    private Integer age;
}
