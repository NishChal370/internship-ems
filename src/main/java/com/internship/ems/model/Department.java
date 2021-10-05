package com.internship.ems.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @NotEmpty
    @Size(max = 50, message = "Name should not be empty")
    private String name;

    @NotEmpty
    @Size(max = 100, message = "Description should not be empty")
    private String description;

}

