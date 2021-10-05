package com.internship.ems.service;

import java.util.List;
import com.internship.ems.model.Salary;
import org.springframework.stereotype.Service;
import com.internship.ems.dao.SalaryRepository;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepo;

    public Salary saveSalary(Salary salary){
        return salaryRepo.save(salary);
    }

    public Salary getById(Integer id){
        return salaryRepo.findById(id).orElseThrow(EntityExistsException::new);
    }

    public List<Salary> getAll(){
        return (List<Salary>) salaryRepo.findAll();
    }

    public Salary updateSalary(Integer id, Salary newSalary){
        Salary existingSalary = salaryRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        existingSalary.setIssueDate(newSalary.getIssueDate());
        existingSalary.setAmount(newSalary.getAmount());
        existingSalary.setBonus(newSalary.getBonus());
        salaryRepo.save(existingSalary);

        return existingSalary;
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
