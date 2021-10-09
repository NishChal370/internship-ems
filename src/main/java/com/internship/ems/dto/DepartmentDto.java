package com.internship.ems.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.internship.ems.model.Employee;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Size(max = 50)
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Size(max = 100)
    @NotEmpty(message = "Description should not be empty")
    private String description;

    private List<Employee> employee;
}
