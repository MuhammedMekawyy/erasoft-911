package com.unimansystem.service.impl;

import com.unimansystem.dto.InstructorDto;
import com.unimansystem.model.Course;
import com.unimansystem.model.Instructor;
import com.unimansystem.repo.CourseRepo;
import com.unimansystem.repo.InstructorRepo;
import com.unimansystem.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepo instructorRepo;
    private final CourseRepo courseRepo;

    @Override
    public List<InstructorDto> allInstructors() {
        return instructorRepo.findAll().stream().map(
                this::toDTO
        ).collect(Collectors.toList());
    }

    @Override
    public List<Long> coursesIds(Long instructorId) {
        Instructor instructor = instructorRepo.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        return instructor.getCourses()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toList());
    }

    @Override
    public InstructorDto createInstructor(InstructorDto instructorDto) {
        if (instructorDto.getId() != null) {
            throw new IllegalArgumentException("ID must not be provided when creating a instructor");
        }

        List<Course> courses = courseRepo.findAllById(instructorDto.getCourseIds());


        Instructor instructor = new Instructor();
        instructor.setName(instructorDto.getName());
        instructor.setEmail(instructorDto.getEmail());
        instructor.setCourses(courses);
        Instructor saved = instructorRepo.save(instructor);
        return toDTO(saved);
    }


    private InstructorDto toDTO(Instructor instructor) {
        Set<Long> courseIds = instructor.getCourses()
                .stream()
                .map(Course::getId)
                .collect(Collectors.toSet());

        InstructorDto dto = new InstructorDto();
        dto.setId(instructor.getId());
        dto.setName(instructor.getName());
        dto.setEmail(instructor.getEmail());
        dto.setCourseIds(courseIds);
        return dto;
    }
}
