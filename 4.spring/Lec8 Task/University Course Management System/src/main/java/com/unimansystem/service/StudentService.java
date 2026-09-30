package com.unimansystem.service;

import com.unimansystem.dto.StudentDto;

import java.util.List;

public interface StudentService {
     StudentDto createStudent(StudentDto studentDto);

     List<StudentDto> allStudents();

     StudentDto getById(Long id);

     StudentDto registerToCourse(Long StudentId , Long CourseId);

}