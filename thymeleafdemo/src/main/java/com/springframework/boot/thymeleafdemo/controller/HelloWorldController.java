package com.springframework.boot.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    // need a controller method to show initial HTML form

    // @GetMapping("/showForm")
    // POST mapping will break the code - on purpose:
    // @PostMapping("/showForm")
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to read form data
    // and add data to the model

    @RequestMapping("/processFormV2")
    public String letsShout(HttpServletRequest request, Model model) {

        // read the request param from the HTML form
        String theName = request.getParameter("studentName");

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Yo! " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

    // @GetMapping("/processFormV3")
    @RequestMapping("/processFormV3")
    public String letsShoutAgain(@RequestParam("studentName") String theName,
                                 Model model) {

        // convert the data to all caps
        theName = theName.toUpperCase();

        // create the message
        String result = "Hello, V3! Welcome, " + theName;

        // add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

}
