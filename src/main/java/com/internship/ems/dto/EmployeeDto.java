package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class EmployeeDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

//    @Column(nullable = false)
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;

//    @Column(nullable = false)
    @NotEmpty(message = "Last should not be empty")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Age should not be empty")
    private int age;

    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "Designation should not be empty")
    private String designation;

    private Date hireDate;

    private Date resignedDate;

    private String address;

    @JsonBackReference(value = "employee-department")
    private Department department;

    @JsonBackReference(value = "employee-salary")
    public Salary salary;
}
