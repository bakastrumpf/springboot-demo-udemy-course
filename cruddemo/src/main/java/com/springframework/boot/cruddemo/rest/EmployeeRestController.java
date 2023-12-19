package com.springframework.boot.cruddemo.rest;

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
		
		// also just in case they pass an ID in JSON, set ID to 
		// this is to force a save of new item instead of update
		
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
