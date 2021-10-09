package com.internship.ems.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import org.mapstruct.InheritInverseConfiguration;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    List<DepartmentDto> modelsToDtos(List<Department> departments);

    DepartmentDto modelToDto(Department department);

    @InheritInverseConfiguration
    Department dtoToModel(DepartmentDto departmentDto);
}
