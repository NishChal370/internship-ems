package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Employee;
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
    public List<Employee> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("/addEmployee")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        return service.saveEmployee(employee);
    }

    @PutMapping("/updateEmployee/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employeeInfo) {
        return service.updateEmployee(id, employeeInfo);
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
