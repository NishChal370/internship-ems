package com.internship.ems.mapper;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

//    DepartmentMapper INSTANCE = Mappers.getMapper(DepartmentMapper.class); //-> to get product mapper implementation class

    List<DepartmentDto> modelsToDtos(List<Department> departments);

    DepartmentDto modelToDto(Department department);

    @InheritInverseConfiguration
    Department dtoToModel(DepartmentDto departmentDto);
}
