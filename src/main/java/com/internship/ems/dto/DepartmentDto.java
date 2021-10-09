package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

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
