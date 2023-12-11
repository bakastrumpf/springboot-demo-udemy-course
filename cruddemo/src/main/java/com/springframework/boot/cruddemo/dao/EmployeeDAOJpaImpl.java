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

}
