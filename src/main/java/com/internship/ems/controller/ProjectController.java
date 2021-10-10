package com.internship.ems.controller;

import java.util.List;
import javax.validation.Valid;

import com.internship.ems.dto.ProjectDto;
import com.internship.ems.service.ProjectService;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@Validated
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/projects")
    public List<ProjectDto> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable int id){
        return service.getById(id);
    }

    @PostMapping("/saveProject")
    public ProjectDto saveProject(@Valid @RequestBody ProjectDto projectDto){
        return service.saveProject(projectDto);
    }

    @PutMapping("/updateProject/{id}")
    public ProjectDto updateProject(@PathVariable int id,@RequestBody ProjectDto projectInfoDto){
        System.out.println("Upsdate "+projectInfoDto);
        return service.updateProject(id, projectInfoDto);
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
