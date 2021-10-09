package com.internship.ems.mapper;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

//    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    List<EmployeeDto> modelsToDtos(List<Employee> employee);

    EmployeeDto modelToDto(Employee employee);

    @InheritInverseConfiguration
    Employee DtoToModel(EmployeeDto employeeDto);
}
