package com.spring_demo.test_app.rest;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	// expose "/" that returns "Hello, World!"

	@GetMapping("/")
	public String sayHello() {
		return "Hello, World!";
	}
	
	// expose a new "workout" endpoint
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run your daily 7k!";
	}
	
	// expose a new "fortune" endpoint
	@GetMapping("/fortune")
	public String fortuneTeller() {
		return "Today is your lucky day!";
	}
}
