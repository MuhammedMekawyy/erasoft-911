package com.lec10task.service.impl;

import com.lec10task.dto.TeacherDto;
import com.lec10task.map.TeacherMapper;
import com.lec10task.repo.TeacherRepo;
import com.lec10task.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepo teacherRepo;
    private final TeacherMapper teacherMapper;

    @Override
    @Transactional(readOnly = true)
    public List<TeacherDto> getAllTeachersWithStudents() {
        return teacherMapper.toDtoList(teacherRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public TeacherDto getTeacherWithStudentsById(Long id) {
        return teacherMapper.toDto(teacherRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Teacher not found with id " + id)));
    }
}