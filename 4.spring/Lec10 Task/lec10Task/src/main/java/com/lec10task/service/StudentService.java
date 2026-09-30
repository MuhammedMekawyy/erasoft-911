package com.lec10task.service;

import com.lec10task.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAllStudentsWithTeachers();
    StudentDto getStudentWithTeachersById(Long id);
}
