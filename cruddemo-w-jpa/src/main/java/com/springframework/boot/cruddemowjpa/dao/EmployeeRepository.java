package com.springframework.boot.cruddemowjpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springframework.boot.cruddemowjpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	// no need to write any other code
	// the beauty of Spring data jpa

}
