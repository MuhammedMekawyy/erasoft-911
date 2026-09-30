package com.lec10task.map;

import com.lec10task.dto.StudentDto;
import com.lec10task.model.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    List<StudentDto> toDtoList(List<Student> students);
}