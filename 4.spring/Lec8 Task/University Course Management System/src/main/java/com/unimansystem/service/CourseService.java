package com.unimansystem.service;

import com.unimansystem.dto.CourseDto;

import java.util.List;

public interface CourseService {

    CourseDto saveCourse(CourseDto courseDto);
    List<CourseDto> allCourses();
}
