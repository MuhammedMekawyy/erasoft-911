package com.unimansystem.controller;

//Student APIs:
//Create a student
//
//Get all students
//
//Get student by ID
//
//Register a student to a course

import com.unimansystem.dto.StudentDto;
import com.unimansystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;



    @PostMapping("/Student/post")
    public StudentDto saveStudent(@RequestBody @Validated StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    @GetMapping("/Student/Get")
    public List<StudentDto> getAllStudents() {
        return studentService.allStudents();
    }

    @GetMapping("/Student/Get/{id}")
    public StudentDto getStudentById(@PathVariable  Long id) {
        return studentService.getById(id);
    }


    @PostMapping("/Student/{studentId}/Course/{courseId}")
    public StudentDto enrollCourse(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        return studentService.registerToCourse(studentId, courseId);
    }



}
