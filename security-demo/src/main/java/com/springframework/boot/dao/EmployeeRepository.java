package com.springframework.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springframework.boot.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
