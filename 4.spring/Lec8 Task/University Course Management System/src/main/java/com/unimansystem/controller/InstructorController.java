package com.unimansystem.controller;

//Instructor APIs:
//Create an instructor done
//
//Get all instructors done
//
//Get courses taught by an instructor done

import com.unimansystem.dto.InstructorDto;
import com.unimansystem.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @GetMapping("/instructor/get")
    public List<InstructorDto> getAllInstructors() {
        return instructorService.allInstructors();
    }

    @GetMapping("/instructor/{instructorId}/get/courses")
    public List<Long> getAllCoursesTaughtByInstructor(@PathVariable Long instructorId) {
        return instructorService.coursesIds(instructorId);
    }

    @PostMapping("/instructor/post")
    public InstructorDto SaveInstructor(@RequestBody @Validated InstructorDto instructorDto) {
        return instructorService.createInstructor(instructorDto);
    }


}
