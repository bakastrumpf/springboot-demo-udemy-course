package com.udemy.springcore.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k! ";
	}
	
	public TrackCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}

}
