package com.internship.ems.service;

import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    public Department saveDepartment(Department department){
        return departmentRepo.save(department);
    }

    public Department getById(int id){
        return departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Department> getAll(){
        return (List<Department>) departmentRepo.findAll();
    }

    public Department updateEmployee(Integer id, Department newDepartment){
        Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        department.setName(newDepartment.getName());
        department.setDescription(newDepartment.getDescription());
        departmentRepo.save(department);

        return department;
    }

    public String deleteDepartment(Integer id){
        departmentRepo.deleteById(id);

        return "id "+id+" deleted !!";
    }

    public String deleteAll(){
        departmentRepo.deleteAll();

        return "Department All deleted";
    }
}
