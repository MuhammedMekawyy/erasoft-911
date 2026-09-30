package com.unimansystem.repo;

import com.unimansystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,Long>  {
}
