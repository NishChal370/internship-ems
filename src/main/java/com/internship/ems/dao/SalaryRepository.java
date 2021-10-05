package com.internship.ems.dao;

import com.internship.ems.model.Salary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer> {
}
