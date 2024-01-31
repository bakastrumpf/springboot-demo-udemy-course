package com.springframework.boot.cruddemoproject.controller;

import com.springframework.boot.cruddemoproject.entity.Employee;
import com.springframework.boot.cruddemoproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

        @GetMapping("/list")
        // add mapping for "/list"
        public String listEmployees(Model theModel){

            // get employees from db
            List<Employee> theEmployees = employeeService.findAll();

            // add to the spring model
            theModel.addAttribute("employees", theEmployees);

            return "list-employees";
        }

}
