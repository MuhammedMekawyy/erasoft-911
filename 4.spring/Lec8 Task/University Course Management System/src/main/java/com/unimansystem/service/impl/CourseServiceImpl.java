package com.unimansystem.service.impl;

import com.unimansystem.dto.CourseDto;
import com.unimansystem.model.Course;
import com.unimansystem.model.Instructor;
import com.unimansystem.model.Student;
import com.unimansystem.repo.CourseRepo;
import com.unimansystem.repo.InstructorRepo;
import com.unimansystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;
    private final InstructorRepo instructorRepo;

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        if (courseDto.getId() != null) {
            throw new IllegalArgumentException("ID must not be provided when creating a course");
        }
        Instructor instructor = instructorRepo.findById(courseDto.getInstructorId())
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        Course course = new Course();
        course.setTitle(courseDto.getTitle());
        course.setDescription(courseDto.getDescription());
        course.setInstructor(instructor);
        Course saved = courseRepo.save(course);
        return toDTO(saved);
    }

    @Override
    public List<CourseDto> allCourses() {
        return  courseRepo.findAll().stream().map(
                this::toDTO
        ).collect(Collectors.toList());
    }





    private CourseDto toDTO(Course course) {
        Set<Long> studentIds = course.getStudents()
                .stream()
                .map(Student::getId)
                .collect(Collectors.toSet());

        CourseDto dto = new CourseDto();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setInstructorId(course.getInstructor().getId());
        dto.setStudentIds(studentIds);
        return dto;
    }
}
