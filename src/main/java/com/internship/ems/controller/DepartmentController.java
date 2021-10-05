package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/api/departments")
    public List<Department> getAll(){
        return service.getAll();
    }

    @GetMapping("/api/department/{id}")
    public Department getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PutMapping("/api/save/department")
    public ResponseEntity<Department> saveDepartment(@Valid @RequestBody Department department){
        return new ResponseEntity<Department>(service.saveDepartment(department), HttpStatus.CREATED);
    }

    @PatchMapping("/api/update/department/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department){
        return service.updateEmployee(id, department);
    }

    @DeleteMapping("/api/delete/department/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        return service.deleteDepartment(id);
    }

    @DeleteMapping("/api/delete/all/department")
    public String deleteAll(){
        return service.deleteAll();
    }
}
