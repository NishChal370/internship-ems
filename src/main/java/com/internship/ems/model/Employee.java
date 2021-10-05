package com.internship.ems.model;

import lombok.Data;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.NotEmpty;


@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotEmpty
    @Size(min = 1, message = "FirstName should not be empty")
    private String firstName;

    @NotEmpty
    @Size(min = 1, message = "Last should not be empty")
    private String lastName;

    @NotEmpty
    @Size(min = 1, message = "Gender should not be empty")
    private String gender;

    @NotNull(message = "Age should not be empty")
    @Min(1)
    private int age;

    @NotEmpty
    @Size(min = 1, message = "Email should not be empty")
    private String email;

    @NotEmpty
    @Size(min = 1, message = "Designation should not be empty")
    private String designation;

    @NotNull(message = "Hiring Date should not be empty")
    private Date hireDate;

    private Date resignedDate;
    private String address;

}
