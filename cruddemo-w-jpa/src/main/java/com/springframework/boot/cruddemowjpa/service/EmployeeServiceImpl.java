package com.springframework.boot.cruddemowjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.springframework.boot.cruddemowjpa.dao.EmployeeRepository;
import com.springframework.boot.cruddemowjpa.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	
	@Override	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	
	@Override
	public Employee findById(int theId) {
		// use Optional from Java8 to check if id is null
		Optional<Employee> result = employeeRepository.findById(theId);
		Employee theEmployee = null;
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id: " + theId);
		}
		return theEmployee;
	}

	
	@Override
	// no need for @Transactional because JPA provides it
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	
	@Override
	// no need for @Transactional because JPA provides it
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}


}
