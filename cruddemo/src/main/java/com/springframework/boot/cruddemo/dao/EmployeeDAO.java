package com.springframework.boot.cruddemo.dao;

import java.util.List;

import com.springframework.boot.cruddemo.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();

}
