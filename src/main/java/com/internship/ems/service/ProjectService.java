package com.internship.ems.service;

import java.util.List;

import com.internship.ems.dto.ProjectDto;
import com.internship.ems.mapper.ProjectMapper;
import com.internship.ems.model.Project;
import org.springframework.stereotype.Service;
import com.internship.ems.dao.ProjectRepository;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private ProjectMapper projectMapper;

    public ProjectDto saveProject(ProjectDto projectDto){
        Project projectModel = projectMapper.dtoToModel(projectDto);
        return  projectMapper.modelToDto( projectRepo.save(projectModel) );
    }

    public ProjectDto getById(int id){
        Project projectWithSearchedId = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        return  projectMapper.modelToDto( projectRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }

    public List<ProjectDto> getAll(){
        return projectMapper.modelsToDtos( (List<Project>) projectRepo.findAll() );
    }

    public ProjectDto updateProject(int id, ProjectDto newProjectDto){
        Project newProjectModel= projectMapper.dtoToModel( newProjectDto );

        Project project = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setName(newProjectModel.getName());
        project.setDescription(newProjectModel.getDescription());
        projectRepo.save(project);

        return projectMapper.modelToDto( project );
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
