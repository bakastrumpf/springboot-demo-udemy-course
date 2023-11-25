package com.udemy.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springcore.common.Coach;

@RestController
public class Controller {
	
	// define a private field for the dependency
	
	private Coach myCoach;
	
	// define a constructor for the dependency
	
	@Autowired
	public Controller(Coach theCoach) {
		myCoach = theCoach;
	}
	

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
