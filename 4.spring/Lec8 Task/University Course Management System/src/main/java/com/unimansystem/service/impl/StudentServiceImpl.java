package com.unimansystem.service.impl;

import com.unimansystem.dto.StudentDto;
import com.unimansystem.model.Course;
import com.unimansystem.model.Student;
import com.unimansystem.repo.CourseRepo;
import com.unimansystem.repo.StudentRepo;
import com.unimansystem.service.StudentService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final CourseRepo courseRepo;


    @Override
    public StudentDto createStudent(StudentDto studentDto) {

        if (studentDto.getId() != null) {
            throw new IllegalArgumentException("ID must not be provided when creating a student");
        }
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        Student saved = studentRepo.save(student);
        return toDTO(saved);
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentDto> allStudents() {
        return studentRepo.findAll().stream().map(
                this::toDTO
        ).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public StudentDto getById(Long id) {
        return toDTO(studentRepo.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Student Not Found")));
    }

    @Transactional
    @Override
    public StudentDto registerToCourse(Long StudentId, Long CourseId) {
        Student student=studentRepo.findById(StudentId)
                .orElseThrow(()-> new IllegalArgumentException("Student Not Found"));

        Course course=courseRepo.findById(CourseId)
                .orElseThrow(()-> new IllegalArgumentException("Course Not Found"));

        student.enrollInCourse(course);

        return toDTO(student);

    }

    //helper

    private StudentDto toDTO(Student student) {
        Set<Long> courseIds = student.getCourses()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toSet());

        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourseIds(courseIds);
        return dto;
    }


}
