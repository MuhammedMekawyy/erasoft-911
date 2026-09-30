package com.unimansystem.service;

import com.unimansystem.dto.InstructorDto;
import com.unimansystem.model.Instructor;

import java.util.List;

public interface InstructorService {

    List<InstructorDto> allInstructors();
    List<Long> coursesIds(Long instructorId);
    InstructorDto createInstructor(InstructorDto instructorDto);
}
