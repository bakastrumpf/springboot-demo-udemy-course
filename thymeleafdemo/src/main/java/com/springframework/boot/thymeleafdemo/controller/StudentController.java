package com.springframework.boot.thymeleafdemo.controller;

import com.springframework.boot.thymeleafdemo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    // create method to show form
    @GetMapping("/showForm")
    public String showForm(Model theModel){

        // create a new student object
        Student theStudent = new Student();

        // add student object to the model
        theModel.addAttribute("student", theStudent);

        return "student-form";

    }
}
