package com.lec9task.repo;

import com.lec9task.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    List<Employee> findByNameIn(List<String> names);
}
