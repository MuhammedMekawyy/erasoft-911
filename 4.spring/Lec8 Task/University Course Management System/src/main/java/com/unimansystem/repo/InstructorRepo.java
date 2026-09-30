package com.unimansystem.repo;

import com.unimansystem.model.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepo extends JpaRepository<Instructor, Long> {
}
