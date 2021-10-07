package com.internship.ems.model;

import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "department", schema = "EMS")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Size(max = 50)
    @NotEmpty(message = "Name should not be empty")
    private String name;

    @Size(max = 100)
    @NotEmpty(message = "Description should not be empty")
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

