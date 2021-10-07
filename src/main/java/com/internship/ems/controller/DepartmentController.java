package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Department;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping("/departments")
    public List<Department> getAll(){
        return service.getAll();
    }

    @GetMapping("/department/{id}")
    public Department getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping("/saveDepartment")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return service.saveDepartment(department);
    }

    @PutMapping("/updateDepartment/{id}")
    public Department updateDepartment(@PathVariable Integer id, @RequestBody Department department){
        return service.updateEmployee(id, department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable Integer id){
        return service.deleteDepartment(id);
    }

    @DeleteMapping("/deleteDepartments")
    public String deleteAll(){
        return service.deleteAll();
    }
}
