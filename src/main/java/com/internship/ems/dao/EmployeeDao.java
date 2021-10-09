package com.internship.ems.dao;

import com.internship.ems.model.Employee;
import com.internship.ems.model.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
public class EmployeeDao {
    @Autowired
    private EntityManager entityManager;

    public List<Employee> getEmployeeByNamedQuery(int departmentId) {
        Query namedQuery = entityManager.createNamedQuery("Employee.getEmployeeByNamedQuery");
        namedQuery.setParameter("id", departmentId);
        return namedQuery.getResultList();
    }

    public List<Employee> getEmployeeByTypedQuery(int departmentId) {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("select e from Employee e where e.department.departmentId=:id", Employee.class);
        typedQuery.setParameter("id", departmentId);
        return typedQuery.getResultList();
    }

    public List<Employee> getEmployee(float amount, float bonus) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        Join<Employee, Salary> salary = employeeRoot.join("salary");
        Predicate amountPredicate = criteriaBuilder.greaterThanOrEqualTo(salary.get("amount"), amount);
        Predicate bonusPredicate = criteriaBuilder.lessThanOrEqualTo(salary.get("bonus"), bonus);
        Predicate finalPredicate = criteriaBuilder.and(amountPredicate, bonusPredicate);

        criteriaQuery.where(finalPredicate);

        return entityManager.createQuery(criteriaQuery).getResultList();
    }
}
