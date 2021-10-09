package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.listener.DepartmentListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Entity
@Table(name = "department", schema = "EMS")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(DepartmentListener.class)
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",  fetch = FetchType.LAZY)
    @JsonManagedReference(value =  "employee-department")
    private List<Employee> employee;

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }

}

