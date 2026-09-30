package com.lec10task.service;

import com.lec10task.dto.TeacherDto;

import java.util.List;

public interface TeacherService {

    List<TeacherDto> getAllTeachersWithStudents();
    TeacherDto getTeacherWithStudentsById(Long id);

}
