package com.internship.ems.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "department", schema = "EMS")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @NotEmpty(message = "Name should not be empty")
    @Size(max = 50)
    private String name;

    @NotEmpty(message = "Description should not be empty")
    @Size(max = 100)
    private String description;


    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }

}

