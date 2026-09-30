package com.lec10task.controller;

import com.lec10task.dto.TeacherDto;
import com.lec10task.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity<List<TeacherDto>> getAll() {
        return ResponseEntity.ok(teacherService.getAllTeachersWithStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeacherDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(teacherService.getTeacherWithStudentsById(id));
    }
}