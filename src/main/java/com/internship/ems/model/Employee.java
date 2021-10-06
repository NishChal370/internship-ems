package com.internship.ems.model;

import com.internship.ems.enums.Gender;
import lombok.Data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name = "employee", schema = "EMS", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @NotEmpty(message = "FirstName should not be empty")
    @Column(nullable = false)
    private String firstName;

    @NotEmpty(message = "Last should not be empty")
    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Age should not be empty")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Column(unique=true)
    @Email
    private String email;

    @NotEmpty(message = "Designation should not be empty")
    private String designation;

    private Date hireDate;

    private Date resignedDate;

    @Column(name="address", columnDefinition="default 'Nepal'")
    private String address;


    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }
}
