package com.internship.ems.listener;

import javax.persistence.*;
import org.apache.commons.logging.Log;
import com.internship.ems.model.Department;
import org.apache.commons.logging.LogFactory;

public class DepartmentListener {
    private static Log log = LogFactory.getLog(EmployeeListener.class);

    @PrePersist
    private void beforePost(Department department) {log.info("On processing to add a department");}

    @PreUpdate
    private void beforeUpdate(Department department) {
        log.info("On processing to update department " + department.getDepartmentId());
    }

    @PreRemove
    private void beforeRemove(Department department) {
        log.info("On processing to delete department: " + department.getDepartmentId());
    }

    @PostPersist
    private void afterPost(Department department) {
        log.info("Add process completed for department: " + department.getDepartmentId());
    }

    @PostUpdate
    private void afterUpdate(Department department) {
        log.info("Update process completed for department: " + department.getDepartmentId());
    }

    @PostRemove
    private void afterRemove(Department department) {
        log.info("Delete process completed for department: " + department.getDepartmentId());
    }

    @PostLoad
    private void afterLoad(Department department) {
        log.info("Department loaded from database: " + department.getDepartmentId());
    }
}
