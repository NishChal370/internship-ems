package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/api/employees")
    public List<Employee> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/api/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return service.getById(id);
    }

    @PutMapping("/api/save/employee")
    public ResponseEntity<Employee> saveEmployee( @Valid @RequestBody Employee employee){
        return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
    }

    @PatchMapping("/api/update/employee/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employeeInfo){
        return service.updateEmployee(id, employeeInfo);
    }

    @DeleteMapping("/api/delete/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @DeleteMapping("/api/delete/all/employees")
    public String deleteEmployees(){
        return service.deleteAll();
    }
}
