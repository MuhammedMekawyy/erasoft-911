package com.task3.task57.repo;

import com.task3.task57.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    // 1. Derived Query / Function Name
    // Call with pattern like "ahmed%"
    List<Employee> findByNameLike(String name);

    // 2. Native Query
    @Query(value = "SELECT * FROM Employee e WHERE e.name LIKE :name", nativeQuery = true)
    List<Employee> searchByNameNative(@Param("name") String name);

    // 3. Non-Native Query / JPQL
    @Query("SELECT e FROM Employee e WHERE e.name LIKE :name")
    List<Employee> searchByNameJPQL(@Param("name") String name);
}