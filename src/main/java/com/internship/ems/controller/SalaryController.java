package com.internship.ems.controller;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.service.SalaryService;

import java.util.List;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@Validated
public class SalaryController {
    @Autowired
    SalaryService service;

    @GetMapping("/salaries")
    public List<SalaryDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public SalaryDto getSalaryById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping("/saveSalary")
    public ResponseEntity<SalaryDto> saveSalary(@Valid @RequestBody SalaryDto salaryDto){
        return new ResponseEntity<>(service.saveSalary(salaryDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateSalary/{id}")
    public ResponseEntity<SalaryDto> updateSalary(@PathVariable Integer id, @RequestBody SalaryDto salaryDto){
        return new ResponseEntity<SalaryDto>( service.updateSalary(id, salaryDto) ,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public String deleteSalary(@PathVariable Integer id){

        return service.deleteSalary(id);
    }

    @DeleteMapping("/deleteSalaries")
    public String deleteAll(){

        return service.deleteAll();
    }
}
