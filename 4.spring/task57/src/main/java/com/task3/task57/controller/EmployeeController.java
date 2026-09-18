package com.task3.task57.controller;


import com.task3.task57.model.Employee;
import com.task3.task57.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    // 1. Get All Employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    // 2. Get Employees By List of IDs
    // GET /api/employees/byIds?ids=1,2,3
    @GetMapping("/byIds")
    public ResponseEntity<List<Employee>> getEmployeesByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(employeeService.getEmployeesByIds(ids));
    }

    // 3. Save Employee
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    // 4. Save List of Employees
    @PostMapping("/batch")
    public ResponseEntity<List<Employee>> saveEmployees(@RequestBody List<Employee> employees) {
        return ResponseEntity.ok(employeeService.saveEmployees(employees));
    }

    // 5. Update Employee
    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employee));
    }

    // 6. Update List of Employees
    @PutMapping("/batch")
    public ResponseEntity<List<Employee>> updateEmployees(@RequestBody List<Employee> employees) {
        return ResponseEntity.ok(employeeService.updateEmployees(employees));
    }

    // 7. Delete All Employees
    @DeleteMapping
    public ResponseEntity<Void> deleteAllEmployees() {
        employeeService.deleteAllEmployees();
        return ResponseEntity.noContent().build();
    }

    // 8. Delete Employee By ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    // 9. Delete Employees By List of IDs
    // DELETE /api/employees/byIds?ids=1,2,3
    @DeleteMapping("/byIds")
    public ResponseEntity<Void> deleteEmployeesByIds(@RequestParam List<Long> ids) {
        employeeService.deleteEmployeesByIds(ids);
        return ResponseEntity.noContent().build();
    }

    // 10. Search Employee By Name — three variants

    @GetMapping("/search/derived")
    public ResponseEntity<List<Employee>> searchDerived(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameDerived(name));
    }

    @GetMapping("/search/native")
    public ResponseEntity<List<Employee>> searchNative(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameNative(name));
    }

    @GetMapping("/search/jpql")
    public ResponseEntity<List<Employee>> searchJPQL(@RequestParam String name) {
        return ResponseEntity.ok(employeeService.searchByNameJPQL(name));
    }
}
