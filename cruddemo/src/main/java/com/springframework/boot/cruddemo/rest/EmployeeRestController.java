package com.springframework.boot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.cruddemo.dao.EmployeeDAO;
import com.springframework.boot.cruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDAO employeeDAO;
	
	// quick and dirty: inject employee dao
	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	// expose "/employees" and return a list of employees
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeDAO.findAll();
				
	}
	

}
