package com.springframework.boot.datarest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path="members")
import com.springframework.boot.datarest.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
