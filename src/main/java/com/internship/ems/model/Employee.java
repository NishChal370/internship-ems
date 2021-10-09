package com.internship.ems.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.internship.ems.enums.Gender;

import com.internship.ems.listener.EmployeeListener;
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
@EntityListeners(EmployeeListener.class)
@NamedQuery(name = "Employee.getEmployeeByNamedQuery", query = "select e from Employee e where e.department.departmentId=:id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

//    @Column(nullable = false)
    @NotEmpty(message = "FirstName should not be empty")
    private String firstName;

//    @Column(nullable = false)
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

    @Column(insertable=false, updatable = false, nullable = false, columnDefinition = "varchar(255) default 'Nepal'")
    private String address;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    @JsonBackReference(value = "employee-department")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salaryId")
    @JsonBackReference(value = "employee-salary")
    public Salary salary;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }
}
