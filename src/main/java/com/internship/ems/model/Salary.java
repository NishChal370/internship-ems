package com.internship.ems.model;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryId;

    @NotNull(message = "Issue Date should not be empty")
    private Date issueDate;

    @NotNull
    @Min(1)
    private float amount;

    private float bonus;
}
