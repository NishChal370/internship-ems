package com.internship.ems.service;

import java.util.List;

import com.internship.ems.dao.EmployeeDao;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Employee;
import com.internship.ems.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import com.internship.ems.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeDto saveEmployee( EmployeeDto employeeDto){
        Employee employeeModel = employeeMapper.DtoToModel(employeeDto);
        Employee employeeSaved = employeeRepo.save(employeeModel);

        return employeeMapper.modelToDto( employeeSaved ) ;
    }

    public EmployeeDto getById(int id){
        return employeeMapper.modelToDto( employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }

    public List<EmployeeDto> getAll(){
        List<Employee> employeesList = (List<Employee>) employeeRepo.findAll();

        return employeeMapper.modelsToDtos(employeesList);
    }

    public List<EmployeeDto> getEmployeeByFirstName(String firstName){

        return employeeMapper.modelsToDtos( employeeRepo.getEmployeeByFirstName(firstName) );
    }

    public List<EmployeeDto> getEmployeeByGenderAndAge(Gender gender, int age){

        return employeeMapper.modelsToDtos(employeeRepo.getEmployeeByGenderAndAge(gender, age));
    }

    public List<EmployeeDto> getByNamedQuery(int departmentId) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployeeByNamedQuery(departmentId));
    }

    public List<EmployeeDto> getByTypedQuery(int departmentId) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployeeByTypedQuery(departmentId));
    }

    public List<EmployeeDto> getByCriteriaApi(float amount, float bonus) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployee(amount, bonus));
    }

    public List<EmployeeDto> getEmployeeByGender(Gender gender){
        return employeeMapper.modelsToDtos( employeeRepo.getEmployeeByGender(gender) );
    }

    public EmployeeDto updateEmployee(Integer id, EmployeeDto newEmployeeDto){
        Employee employeeModel = employeeMapper.DtoToModel(newEmployeeDto);

        Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setGender(employeeModel.getGender());
        employee.setAge(employeeModel.getAge());
        employee.setEmail(employeeModel.getEmail());
        employee.setDesignation(employeeModel.getDesignation());
        employee.setHireDate(employeeModel.getHireDate());
        employee.setResignedDate(employeeModel.getResignedDate());
        employee.setAddress(employeeModel.getAddress());
        employeeRepo.save(employee);

        return employeeMapper.modelToDto(employee);
    }

    public String updateById(int id, int age){
        employeeRepo.updateEmployeeById(id, age);
        return "Age of id: "+id+" updated";
    }

    public String deleteEmployee(int id){
        employeeRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }

    public String deleteAll(){
        employeeRepo.deleteAll();

        return "Employee all deleted";
    }

    public String deleteEmployeeById(int id){
        employeeRepo.deleteEmployeeById(id);

        return "ID: "+id+" Deleted";
    }

}
