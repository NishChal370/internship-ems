package com.internship.ems.mapper;

import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Salary;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    List<SalaryDto> modelsToDtos(List<Salary> salaries);

    SalaryDto modelToDto(Salary salary);

    @InheritInverseConfiguration
    Salary dtoToModel(SalaryDto salaryDto);
}
