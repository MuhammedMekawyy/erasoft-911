package com.lec9task.map;

import com.lec9task.dto.EmployeeDto;
import com.lec9task.model.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toDtoList ( List<Employee> employees);

    List<Employee> toEntityList ( List<EmployeeDto> employeeDtoList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "mail", ignore = true)
    void updateEntityFromDto(EmployeeDto dto, @MappingTarget Employee employee);

}
