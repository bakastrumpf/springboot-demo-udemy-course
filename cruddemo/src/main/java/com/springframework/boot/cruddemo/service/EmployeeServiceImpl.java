package com.springframework.boot.cruddemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springframework.boot.cruddemo.dao.EmployeeDAO;
import com.springframework.boot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
		employeeDAO = theEmployeeDAO;
	}
	
	
	@Override	
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

	
	@Override
	public Employee findById(int theId) {
		return employeeDAO.findById(theId);
	}

	
	@Override
	@Transactional // because we are working on the DB
	public Employee save(Employee theEmployee) {
		return employeeDAO.save(theEmployee);
	}

	
	@Override
	@Transactional // because we are working on the DB
	public void deleteById(int theId) {
		employeeDAO.deleteById(theId);
		
	}
	
	

}
