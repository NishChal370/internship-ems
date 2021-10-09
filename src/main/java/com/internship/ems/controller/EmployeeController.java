package com.internship.ems.controller;
import com.internship.ems.service.EmployeeService;

import java.util.List;
import javax.validation.Valid;
import javax.transaction.Transactional;

import com.internship.ems.enums.Gender;
import com.internship.ems.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/employeeByFirstName/{firstName}")
    public List<EmployeeDto> findEmployeeByFirstName(@PathVariable String firstName){
        return service.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/employeeByGenderAndAge/{gender}&{age}")
    public List<EmployeeDto> findEmployeeByGenderAndAge(@PathVariable Gender gender, @PathVariable int age){
        return service.getEmployeeByGenderAndAge(gender, age);
    }

    @GetMapping("/employeesByGender/{gender}")
    public List<EmployeeDto> getEmployeeByGender(@PathVariable Gender gender){

        return service.getEmployeeByGender(gender);
    }

    @GetMapping("/custom/employees/namedQuery")
    public List<EmployeeDto> getEmployeeByNamedQuery(@RequestParam("departmentId") int departmentId) {
        return service.getByNamedQuery(departmentId);
    }

    @GetMapping("/custom/employees/typedQuery")
    public List<EmployeeDto> getEmployeeByTypedQuery(@RequestParam("departmentId") int departmentId) {
        return service.getByTypedQuery(departmentId);
    }

    @GetMapping("/custom/employees/criteriaApi")
    public List<EmployeeDto> getEmployeeByJpql(@RequestParam("amount") float amount, @RequestParam("bonus") float bonus) {
        return service.getByCriteriaApi(amount, bonus);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable int id, @RequestBody EmployeeDto employeeInfoDto) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeInfoDto), HttpStatus.CREATED);
    }

    @Transactional
    @PutMapping("/updateEmployeeAgeById/{id}&{age}")
    public String updateEmployeeAgeById(@PathVariable int id, @PathVariable int age){
        return service.updateById(id, age);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int id){
        return service.deleteEmployee(id);
    }

    @DeleteMapping("/deleteEmployees")
    public String deleteEmployees(){
        return service.deleteAll();
    }

    @Transactional
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String  deleteEmployeeById(@PathVariable int id){
        return service.deleteEmployeeById(id);
    }



}
