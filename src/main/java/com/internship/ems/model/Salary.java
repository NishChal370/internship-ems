package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.listener.SalaryListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "salary", schema = "EMS")
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(SalaryListener.class)
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryId;

    @NotNull(message = "Issue Date should not be empty")
    private Date issueDate;

    @NotNull
    private float amount;

    private float bonus;

    @OneToOne(mappedBy = "salary")
    @JsonManagedReference(value = "employee-salary")
    private Employee employee;

}
