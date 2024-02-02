package com.springframework.boot.cruddemoproject.dao;

import com.springframework.boot.cruddemoproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

        // no need to write any other code
        // the beauty of Spring data jpa

        // sort by last name

        public List<Employee> findAllByOrderByLastNameAsc();

    }
