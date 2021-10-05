package com.internship.ems.dao;

import com.internship.ems.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
