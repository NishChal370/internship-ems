package com.internship.ems.service;

import java.util.ArrayList;
import java.util.List;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.mapper.DepartmentMapper;
import com.internship.ems.model.Department;
import org.springframework.stereotype.Service;
import javax.persistence.EntityNotFoundException;
import com.internship.ems.dao.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepo;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department departmentModel = departmentMapper.dtoToModel(departmentDto);
        Department DepartmentSaved = departmentRepo.save(departmentModel);

        return departmentMapper.modelToDto(DepartmentSaved);
    }

    public DepartmentDto getById(int id){
        return departmentMapper.modelToDto( departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public List<DepartmentDto> getAll() {
        List<Department> result = new ArrayList<>();
        departmentRepo.findAll().forEach(result::add);

        return departmentMapper.modelsToDtos(result);
    }

    public DepartmentDto  updateEmployee(Integer id, DepartmentDto newDepartmentDto){
        Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        Department newDepartmentModel = departmentMapper.dtoToModel(newDepartmentDto);
        department.setName(newDepartmentModel.getName());
        department.setDescription(newDepartmentModel.getDescription());
        departmentRepo.save(department);

        return departmentMapper.modelToDto(department);
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
