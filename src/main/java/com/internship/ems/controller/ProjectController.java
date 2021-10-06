package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;
import com.internship.ems.model.Project;
import org.springframework.web.bind.annotation.*;
import com.internship.ems.service.ProjectService;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@Validated
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/projects")
    public List<Project> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public Project getProjectById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("/saveProject")
    public Project saveProject(@Valid @RequestBody Project project){
        return service.saveProject(project);
    }

    @PutMapping("/updateProject/{id}")
    public Project updateProject(@PathVariable int id,@RequestBody Project projectInfo){
        return service.updateProject(id, projectInfo);
    }

    @DeleteMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable int id){
        return service.deleteProject(id);
    }

    @DeleteMapping("/deleteProjects")
    public String deleteProject(){
        return service.deleteAll();
    }
}
