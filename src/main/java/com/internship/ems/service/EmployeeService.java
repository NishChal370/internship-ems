package com.internship.ems.service;

import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.model.Employee;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    public Employee saveEmployee( Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee getById(int id){
        return employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Employee> getAll(){
        return (List<Employee>) employeeRepo.findAll();
    }

    public Employee updateEmployee(Integer id, Employee newEmployee){
        Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setGender(newEmployee.getGender());
        employee.setAge(newEmployee.getAge());
        employee.setEmail(newEmployee.getEmail());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setResignedDate(newEmployee.getResignedDate());
        employee.setAddress(newEmployee.getAddress());
        employeeRepo.save(employee);

        return employee;
    }

    public String deleteEmployee(int id){
        employeeRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }

    public String deleteAll(){
        employeeRepo.deleteAll();

        return "Employee all deleted";
    }
}
