package com.lec9task.dto;

import com.lec9task.model.Mail;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Long id;


    @NotBlank
    private String name;


    @Min(value = 16, message = "Age must be greater than 15")
    @Max(value = 39, message = "Age must be less than 40")
    private Integer age;


    @Min(value = 5001, message = "Salary must be greater than 5000")
    @Max(value = 9999, message = "Salary must be less than 10000")
    private Double salary;


    private List<Mail> mail;
}
