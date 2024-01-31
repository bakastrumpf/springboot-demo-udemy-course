package com.springframework.boot.cruddemoproject.service;

import com.springframework.boot.cruddemoproject.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
