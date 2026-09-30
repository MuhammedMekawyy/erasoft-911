package com.unimansystem.controller;

import com.unimansystem.dto.CourseDto;
import com.unimansystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Course APIs:
//Create a course done
//
//Get all courses done
//
//Assign an instructor to a course done

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;


    @PostMapping("/courses/post")
    public CourseDto CreateCourse(@RequestBody @Validated CourseDto courseDto) {
        return courseService.saveCourse(courseDto);
    }


    @GetMapping("/courses/get")
    public List<CourseDto> getAllCourses() {
       return courseService.allCourses();
    }

}
