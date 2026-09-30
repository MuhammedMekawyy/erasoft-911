package com.lec10task.repo;

import com.lec10task.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepo  extends JpaRepository<Teacher, Long> {
}
