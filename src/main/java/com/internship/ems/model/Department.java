package com.internship.ems.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.internship.ems.listener.DepartmentListener;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotEmpty;

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

}

