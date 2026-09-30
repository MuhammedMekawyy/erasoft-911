package com.lec9task.controller;

//create API to create Employee done
//create API to update Employee done
//create API to remove Employee done
//create API to get all Employee done
//create API to get Employee by id done
//create API to get Employee by List of ID done
//create API to get Employee by List of name done

import com.lec9task.dto.EmployeeDto;
import com.lec9task.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/Employee/post")
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody @Validated EmployeeDto employeeDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(employeeService.createEmployee(employeeDto));
    }

    @GetMapping("/Employee/get")
    public ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.allEmployees());
    }

    @GetMapping("/Employee/{id}/get")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @DeleteMapping("/Employee/{id}/delete")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.removeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/Employee/put")
    public ResponseEntity<EmployeeDto> updateEmployee(@RequestBody @Validated EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeDto));
    }

    @GetMapping("/by-ids")
    public ResponseEntity<List<EmployeeDto>> getByIds(@RequestParam List<Long> ids) {
        return ResponseEntity.ok(employeeService.getEmployeesByIds(ids));
    }

    @GetMapping("/by-names")
    public ResponseEntity<List<EmployeeDto>> getByNames(@RequestParam List<String> names) {
        return ResponseEntity.ok(employeeService.getEmployeesByNames(names));
    }

}
