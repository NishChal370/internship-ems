package com.internship.ems.dao;

import com.internship.ems.model.Project;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer> {
}
