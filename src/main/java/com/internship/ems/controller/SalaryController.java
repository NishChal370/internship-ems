package com.internship.ems.controller;

import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class SalaryController {
    @Autowired
    private SalaryService service;

    @GetMapping("/salaries")
    public List<Salary> getAll(){
        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalaryById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping("/saveSalary")
    public Salary saveSalary(@Valid @RequestBody Salary salary){
        return service.saveSalary(salary);
    }

    @PutMapping("/updateSalary/{id}")
    public Salary updateSalary(@PathVariable Integer id, @RequestBody Salary salary){
        return service.updateSalary(id, salary);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public String deleteSalary(@PathVariable Integer id){
        service.deleteSalary(id);

        return "Salary of id: "+id+" deleted!!";
    }

    @DeleteMapping("/deleteSalaries")
    public String deleteAll(){
        service.deleteAll();

        return "All Salary deleted";
    }
}
