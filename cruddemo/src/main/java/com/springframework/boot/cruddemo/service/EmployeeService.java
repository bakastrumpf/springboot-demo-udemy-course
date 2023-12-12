package com.springframework.boot.cruddemo.service;

import java.util.List;

import com.springframework.boot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

}
