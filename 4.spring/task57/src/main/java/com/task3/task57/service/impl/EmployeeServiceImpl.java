package com.task3.task57.service.impl;



import com.task3.task57.model.Employee;
import com.task3.task57.repo.EmployeeRepo;
import com.task3.task57.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> getEmployeesByIds(List<Long> ids) {
        return employeeRepo.findAllById(ids);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> saveEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> updateEmployees(List<Employee> employees) {
        return employeeRepo.saveAll(employees);
    }

    @Override
    public void deleteAllEmployees() {
        employeeRepo.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public void deleteEmployeesByIds(List<Long> ids) {
        employeeRepo.deleteAllById(ids);
    }

    @Override
    public List<Employee> searchByNameDerived(String namePattern) {
        return employeeRepo.findByNameLike(namePattern);
    }

    @Override
    public List<Employee> searchByNameNative(String namePattern) {
        return employeeRepo.searchByNameNative(namePattern);
    }

    @Override
    public List<Employee> searchByNameJPQL(String namePattern) {
        return employeeRepo.searchByNameJPQL(namePattern);
    }
}
