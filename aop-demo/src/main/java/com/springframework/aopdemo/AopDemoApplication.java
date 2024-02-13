package com.springframework.aopdemo;

import com.springframework.aopdemo.DAO.AccountDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	// public CommandLineRunner commandLineRunner(String[] args){
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO){

		return runner -> {
			// System.out.println("Hello, world!");
			demoTheBeforeAdvice(theAccountDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO) {

		// call the business method
		theAccountDAO.addAccount();
	}

}
