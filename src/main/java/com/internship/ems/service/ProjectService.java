package com.internship.ems.service;

import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.model.Employee;
import com.internship.ems.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    public Project saveProject(Project project){
        return projectRepo.save(project);
    }

    public Project getById(int id){
        return projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Project> getAll(){
        return (List<Project>) projectRepo.findAll();
    }

    public Project updateProject(int id, Project newProject){
        Project project = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setName(newProject.getName());
        project.setDescription(newProject.getDescription());
        projectRepo.save(project);

        return project;
    }

    public String deleteProject(int id){
        projectRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }

    public String deleteAll(){
        projectRepo.deleteAll();

        return "Employee all deleted";
    }
}
