package com.springframework.boot.cruddemoproject.controller;

import com.springframework.boot.cruddemoproject.entity.Employee;
import com.springframework.boot.cruddemoproject.service.EmployeeService;
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

    @GetMapping("/showAddForm")
    public String showAddForm(Model theModel){

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam("employeeId") int theId, Model theModel){

        // get employee from service
        Employee theEmployee = employeeService.findById(theId);

        // set employee in the model to prepopulate the form
        theModel.addAttribute("employee", theEmployee);

        // send over to the form
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId){

        // delete by id
        employeeService.deleteById(theId);

        // send over to the form
        return "redirect:/employees/list";

    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

        // save the employee
        employeeService.save(theEmployee);

        // use a redirect to prevent duplicate submissions
        // implementation of "Post/Redirect/Get" pattern
        return "redirect:/employees/list";
    }

    // add mapping for "/list"
    @GetMapping("/list")
    public String listEmployees(Model theModel){

        // get employees from db
        List<Employee> theEmployees = employeeService.findAll();

        // add to the spring model
        theModel.addAttribute("employees", theEmployees);

        return "employees/list-employees";
    }

}
