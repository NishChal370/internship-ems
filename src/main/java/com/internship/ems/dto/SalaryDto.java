package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.model.Employee;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SalaryDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryId;

    @NotNull(message = "Issue Date should not be empty")
    private Date issueDate;

    @NotNull
    private float amount;

    private float bonus;

    private Employee employee;
}
