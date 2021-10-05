package com.internship.ems.dao;

import com.internship.ems.model.Salary;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface SalaryRepository extends CrudRepository<Salary, Integer> {
}
