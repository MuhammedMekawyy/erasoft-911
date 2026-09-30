package com.lec10task.dto;

import com.lec10task.model.Student;
import lombok.Data;


import java.util.HashSet;
import java.util.Set;

@Data
public class TeacherDto {

    private Long id;


    private String name;


    private Set<Student> students = new HashSet<>();
}
