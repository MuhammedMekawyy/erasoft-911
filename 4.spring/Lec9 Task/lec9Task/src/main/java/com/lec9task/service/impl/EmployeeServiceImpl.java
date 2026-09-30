package com.lec9task.service.impl;

import com.lec9task.dto.EmployeeDto;
import com.lec9task.map.EmployeeMapper;
import com.lec9task.model.Employee;
import com.lec9task.repo.EmployeeRepo;
import com.lec9task.service.EmployeeService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getId() != null) {
            throw new IllegalArgumentException
                    ("ID must not be provided when creating a Employee");
        }
         Employee employee = employeeMapper.toEntity(employeeDto);
         employeeRepo.save(employee);
         return employeeMapper.toDto(employee);
    }

    @Override
    public List<EmployeeDto> allEmployees() {
        return employeeMapper.toDtoList(employeeRepo.findAll());
    }

    @Override
    public EmployeeDto getById(Long id) {
        return employeeMapper.toDto(
                employeeRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("employee Not Found"))
        );
    }

    @Override
    public void removeById(Long id) {
        Employee employee =
                employeeRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("employee Not Found"));
        employeeRepo.delete(employee);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getId() == null) {
            throw new IllegalArgumentException("ID must be provided when updating an Employee");
        }

        Employee employee = employeeRepo.findById(employeeDto.getId())
                .orElseThrow(() -> new EntityNotFoundException(
                        "Employee not found with id " + employeeDto.getId()));

        employeeMapper.updateEntityFromDto(employeeDto, employee);

        return employeeMapper.toDto(employeeRepo.save(employee));
        }

    @Override
    public List<EmployeeDto> getEmployeesByIds(List<Long> ids) {
        return employeeMapper.toDtoList(employeeRepo.findAllById(ids));
    }

    @Override
    public List<EmployeeDto> getEmployeesByNames(List<String> names) {
        return employeeMapper.toDtoList(employeeRepo.findByNameIn(names));
    }
}
