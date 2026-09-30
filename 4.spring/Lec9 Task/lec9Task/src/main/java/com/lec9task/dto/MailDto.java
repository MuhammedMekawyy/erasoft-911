package com.lec9task.dto;

import com.lec9task.model.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MailDto {

    private Long id;


    @NotBlank
    private String name;

    @Email
    private String content;

    @NotNull
    private Employee employee;
}
