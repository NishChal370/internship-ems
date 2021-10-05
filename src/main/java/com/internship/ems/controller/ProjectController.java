package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/api/project")
    public List<Project> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/api/project/{id}")
    public Project getProjectById(@PathVariable int id){
        return service.getById(id);
    }

    @PutMapping("/api/save/project")
    public ResponseEntity<Project> saveProject(@Valid @RequestBody Project project){
        return new ResponseEntity<Project>(service.saveProject(project), HttpStatus.CREATED);
    }

    @PatchMapping("/api/update/project/{id}")
    public Project updateProject(@PathVariable int id,@RequestBody Project projectInfo){
        return service.updateProject(id, projectInfo);
    }

    @DeleteMapping("/api/delete/project/{id}")
    public String deleteProject(@PathVariable int id){
        return service.deleteProject(id);
    }

    @DeleteMapping("/api/delete/all/project")
    public String deleteProject(){
        return service.deleteAll();
    }
}
