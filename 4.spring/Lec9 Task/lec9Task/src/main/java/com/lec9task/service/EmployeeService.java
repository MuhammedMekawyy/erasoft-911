package com.lec9task.service;

import com.lec9task.dto.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> allEmployees();
    EmployeeDto getById(Long id);
    void removeById(Long id);
    EmployeeDto updateEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getEmployeesByIds(List<Long> ids);
    List<EmployeeDto> getEmployeesByNames(List<String> names);

}
