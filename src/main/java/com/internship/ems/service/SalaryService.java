package com.internship.ems.service;

import java.util.List;
import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Salary;
import com.internship.ems.mapper.SalaryMapper;
import org.springframework.stereotype.Service;
import com.internship.ems.dao.SalaryRepository;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;

    @Autowired
    private SalaryMapper salaryMapper;

    public SalaryDto saveSalary(SalaryDto salaryDto){
        Salary salaryModel = salaryMapper.dtoToModel( salaryDto );
        return  salaryMapper.modelToDto( salaryRepo.save(salaryModel) );
    }

    public SalaryDto getById(Integer id){
        return salaryMapper.modelToDto( salaryRepo.findById(id).orElseThrow(EntityExistsException::new) );
    }

    public List<SalaryDto> getAll(){
        return salaryMapper.modelsToDtos( (List<Salary>) salaryRepo.findAll() );
    }

    public SalaryDto updateSalary(Integer id, SalaryDto newSalaryDto){
        Salary salaryModel = salaryMapper.dtoToModel( newSalaryDto );

        Salary existingSalary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        existingSalary.setIssueDate(salaryModel.getIssueDate());
        existingSalary.setAmount(salaryModel.getAmount());
        existingSalary.setBonus(salaryModel.getBonus());
        salaryRepo.save(existingSalary);

        return salaryMapper.modelToDto( existingSalary );
    }

    public String deleteSalary(Integer id){
        salaryRepo.deleteById(id);

        return "id" +id+" deleted!! ";
    }

    public String deleteAll(){
        salaryRepo.deleteAll();

        return "Salary all deleted";
    }
}
