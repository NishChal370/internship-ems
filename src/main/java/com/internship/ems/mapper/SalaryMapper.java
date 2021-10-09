package com.internship.ems.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Salary;
import org.mapstruct.InheritInverseConfiguration;

@Mapper(componentModel = "spring")
public interface SalaryMapper {

//    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    List<SalaryDto> modelsToDtos(List<Salary> salaries);

    SalaryDto modelToDto(Salary salary);

    @InheritInverseConfiguration
    Salary dtoToModel(SalaryDto salaryDto);
}
