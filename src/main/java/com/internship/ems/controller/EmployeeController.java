package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.mapper.EmployeeMapper;
import com.internship.ems.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.EmployeeService;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@Validated
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employees")
    public List<EmployeeDto> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeInfoDto) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeInfoDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @DeleteMapping("/deleteEmployees")
    public String deleteEmployees(){
        return service.deleteAll();
    }
}
