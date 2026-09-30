package com.unimansystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @Size(max = 1000, message = "Description must be at most 1000 characters")
    private String description;


    private Set<Long>studentIds=new HashSet<>();

    @NotNull
    private Long instructorId;



}
