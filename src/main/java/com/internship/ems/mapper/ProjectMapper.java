package com.internship.ems.mapper;

import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Project;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    List<ProjectDto> modelsToDtos(List<Project> projects);

    ProjectDto modelToDto(Project project);
    @InheritInverseConfiguration
    Project dtoToModel(ProjectDto projectDto);

}
