package com.springframework.boot.service;

import java.util.List;

import com.springframework.boot.entity.Employee;

public interface EmployeeService {
	
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
