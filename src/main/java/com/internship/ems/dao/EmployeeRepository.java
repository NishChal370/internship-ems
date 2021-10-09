package com.internship.ems.dao;

import com.internship.ems.enums.Gender;
import com.internship.ems.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> getEmployeeByGender(Gender gender);

    @Query(value = "SELECT * FROM  employee WHERE first_name=:name", nativeQuery = true)
    List<Employee> getUserByFirstName( @Param("name") String firstName);

    @Query("SELECT e FROM Employee e WHERE e.gender =?1 AND e.age =?2")
    List<Employee> getEmployeeByGenderAndAge(Gender gender, int age);

    @Modifying
    @Query("UPDATE Employee e SET e.age=:age WHERE e.employeeId=:employeeId")
    void updateEmployeeById(@Param("employeeId") int employeeId, @Param("age") int age);

    @Modifying
    @Query("DELETE from Employee e WHERE e.employeeId=:employeeId")
    void deleteEmployeeById(@Param("employeeId") int employeeId);

}
