package com.internship.ems.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.internship.ems.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getById(@PathVariable Integer id){
        return departmentService.getById(id);
    }

    @PostMapping("/saveDepartment")
    public ResponseEntity<DepartmentDto> setLaptop(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                departmentService.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Integer id, @RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                departmentService.updateEmployee(id, departmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        return departmentService.deleteDepartment(id);
    }

    @DeleteMapping("/deleteDepartments")
    public String deleteAll(){
        return departmentService.deleteAll();
    }
}
