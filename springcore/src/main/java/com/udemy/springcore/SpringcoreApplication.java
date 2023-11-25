package com.udemy.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// when required classes are outside the default package
// use scanBasePackages
// to tell where they are located
//		(scanBasePackages = {"com.Udemy.springcore",
//		"util"})

public class SpringcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoreApplication.class, args);
	}

}
