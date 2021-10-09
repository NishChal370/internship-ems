package com.internship.ems.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class ProjectDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(max = 50)
    private String name;

    @NotEmpty(message = "Description should not be empty")
    @Size(max = 100)
    private String description;
}
