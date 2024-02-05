package com.springframework.boot.springsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/showLoginPage")
    public String showMyLoginPage(){

        // return "plain-login";
        return "fancy-login";
    }
}
