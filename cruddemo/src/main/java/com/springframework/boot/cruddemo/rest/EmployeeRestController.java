package com.springframework.boot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.cruddemo.dao.EmployeeDAO;
import com.springframework.boot.cruddemo.entity.Employee;
import com.springframework.boot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	// refactor code to use service instead of dao
//	private EmployeeDAO employeeDAO;
	private EmployeeService employeeService;
	
	
	// quick and dirty: inject employee dao
	// refactor code to use service instead of dao
//	public EmployeeRestController(EmployeeDAO theEmployeeDAO) {
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// expose "/employees" and return a list of employees
	// refactor code to use service instead of dao
	@GetMapping("/employee")
	public List<Employee> findAll(){
//		return employeeDAO.findAll();
		return employeeService.findAll();
				
	}
	

}
