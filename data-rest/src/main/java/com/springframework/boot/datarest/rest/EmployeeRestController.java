package com.springframework.boot.datarest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.datarest.entity.Employee;
import com.springframework.boot.datarest.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeService.findAll();		
	}
	
	
	// add mapping for GET /employeees/{employeeId}
	@GetMapping("/employeees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee theEmployee = employeeService.findById(employeeId);
		if (theEmployee == null) {
			throw new RuntimeException("Employee ID not found: " + employeeId);
		}
		return theEmployee;
	}
	
	
	// add mapping for POST /employees - add new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	
	// add mapping for PUT /employees - update existing employee
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	
	// add mapping for DELETE /employeees/{employeeId} - delete employee
	@DeleteMapping("/employeees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee tempEmployee = employeeService.findById(employeeId);
		//throw exception if null
		if(tempEmployee == null) {
			throw new RuntimeException("Employee id not found: " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee id: " + employeeId;
	}
	
}
