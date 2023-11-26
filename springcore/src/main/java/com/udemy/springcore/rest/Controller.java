package com.udemy.springcore.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.springcore.common.Coach;

@RestController
public class Controller {
	
	// define a private field for the dependency
	
	private Coach myCoach;
	
// Field injection
// no longer in use, only in legacy projects
//	@Autowired
//	private Coach myCoach;
	
	// define a constructor for the dependency
	
//	Constructor injection
//	@Autowired
//	public Controller(Coach theCoach) {
//		myCoach = theCoach;
//	}
	
// Setter injection
//	@Autowired
//	public void setCoach(Coach theCoach) {
//		myCoach = theCoach;
//	}
	
// Setter injection
//		@Autowired
//		public void doSomeStuff(Coach theCoach) {
//			myCoach = theCoach;
//		}
//
	
// Qualifier Constructor injection
//	@Autowired
//	public Controller(@Qualifier("cricketCoach") Coach theCoach) {
//		myCoach = theCoach;
//	}
	
// Qualifier Constructor injection
	@Autowired
	public Controller(@Qualifier("tennisCoach") Coach theCoach) {
		myCoach = theCoach;
	}
	
// Qualifier Setter injection
//	@Autowired
//	public void setCoach(@Qualifier("cricketCoach") Coach theCoach) {
//		myCoach = theCoach;
//	}	

	@GetMapping("/dailyworkout")
	public String getDailyWorkout() {
		return myCoach.getDailyWorkout();
	}
}
