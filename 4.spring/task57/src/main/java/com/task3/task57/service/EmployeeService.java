package com.task3.task57.service;

import com.task3.task57.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByIds(List<Long> ids);
    Employee saveEmployee(Employee employee);
    List<Employee> saveEmployees(List<Employee> employees);
    Employee updateEmployee(Employee employee);
    List<Employee> updateEmployees(List<Employee> employees);
    void deleteAllEmployees();
    void deleteEmployeeById(Long id);
    void deleteEmployeesByIds(List<Long> ids);

    List<Employee> searchByNameDerived(String namePattern);
    List<Employee> searchByNameNative(String namePattern);
    List<Employee> searchByNameJPQL(String namePattern);
}