package com.udemy.springcore.common;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
	
	public CricketCoach() {
		System.out.println("In constructor: " + getClass().getSimpleName());
	}
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practice fast bowling for 15 mins.";
	}

}
