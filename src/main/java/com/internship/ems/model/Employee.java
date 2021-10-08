package com.internship.ems.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.enums.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.time.ZoneId;
import javax.persistence.*;
import java.time.LocalDate;
import javax.validation.constraints.*;


@Data
@Entity
@Table(name = "employee", schema = "EMS", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

    @Column(nullable = false)
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;

    @Column(nullable = false)
    @NotEmpty(message = "Last should not be empty")
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @NotNull(message = "Age should not be empty")
    private int age;

    @Email
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "Designation should not be empty")
    private String designation;

    private Date hireDate;

    private Date resignedDate;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="department_id")
    @JsonBackReference
    private Department department;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_id")
    @JsonBackReference
    private Salary salary;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }
}
