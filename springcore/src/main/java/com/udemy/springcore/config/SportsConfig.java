package com.udemy.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.udemy.springcore.common.Coach;
import com.udemy.springcore.common.SwimCoach;

@Configuration
public class SportsConfig {
	
	@Bean("aquatic")
	public Coach swimCoach() {
		return new SwimCoach();
	}

}
