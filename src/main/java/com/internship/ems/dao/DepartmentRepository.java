package com.internship.ems.dao;

import com.internship.ems.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Integer> {
}
