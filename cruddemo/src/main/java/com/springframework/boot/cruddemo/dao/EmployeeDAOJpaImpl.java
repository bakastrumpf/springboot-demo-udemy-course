package com.springframework.boot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springframework.boot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define field of entity manager
	private EntityManager entityManager;
	
	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		// create a query
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		// execute query and get results list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		return employees;
	}

	
	@Override
	// here we do not use @Transactional because it will be handled at the service layer
	public Employee findById(int theId) {

		// get employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// return employee		
		return theEmployee;
	}
	

	@Override
	public Employee save(Employee theEmployee) {

		// save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		// merge: if id == 0 then insert/save else update
		
		// return dbEmployee
		return dbEmployee;
		// in case of insert, dbEmployee has the updated ID from the DB
	}
	

	@Override
	// here we do not use @Transactional because it will be handled at the service layer
	public void deleteById(int theId) {

		// find employee by ID
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		// remove the employee
		entityManager.remove(theEmployee);
	}
	
	
}
