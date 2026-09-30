package com.lec10task.map;

import com.lec10task.dto.TeacherDto;
import com.lec10task.model.Teacher;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    List<TeacherDto> toDtoList(List<Teacher> teachers);
}