package com.lec11task.dto;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserDto {   // request body

    @NotBlank(message = "Name is required")
    @Size(min = 8, message = "Name must be more than 7 characters")
    private String name;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

    @NotBlank(message = "Password is required")
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$",
            message = "Password must contain an uppercase letter, a lowercase letter, a number and a special character")
    private String password;
}

