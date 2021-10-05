package com.internship.ems.controller;

import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    private SalaryService service;

    @GetMapping("/api/salaries")
    public List<Salary> getAll(){
        return service.getAll();
    }

    @GetMapping("/api/salary/{id}")
    public Salary getSalaryById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/api/save/salary")
    public ResponseEntity<Salary> saveSalary(@Valid @RequestBody Salary salary){
        return new ResponseEntity<Salary>(service.saveSalary(salary), HttpStatus.CREATED);
    }


    @PatchMapping("/api/update/salary/{id}")
    public Salary updateSalary(@PathVariable Integer id, @RequestBody Salary salary){
        return service.updateSalary(id, salary);
    }

    @DeleteMapping("/api/delete/salary/{id}")
    public String deleteSalary(@PathVariable Integer id){
        service.deleteSalary(id);

        return "Salary of id: "+id+" deleted!!";
    }

    @DeleteMapping("/api/delete/salaries")
    public String deleteAll(){
        service.deleteAll();

        return "All Salary deleted";
    }
}
