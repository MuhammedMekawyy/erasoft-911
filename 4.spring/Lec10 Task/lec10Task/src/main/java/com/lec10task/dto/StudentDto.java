package com.lec10task.dto;

import com.lec10task.model.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class StudentDto {


    private Long id;


    private String name;


    private Set<Teacher> teachers = new HashSet<>();
}
