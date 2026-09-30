package com.lec10task.service.impl;

import com.lec10task.dto.StudentDto;
import com.lec10task.map.StudentMapper;
import com.lec10task.repo.StudentRepo;
import com.lec10task.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> getAllStudentsWithTeachers() {
        return studentMapper.toDtoList(studentRepo.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto getStudentWithTeachersById(Long id) {
        return studentMapper.toDto(studentRepo.findById(id).orElseThrow(
                () -> new NoSuchElementException("Student not found with id " + id)));
    }
}
