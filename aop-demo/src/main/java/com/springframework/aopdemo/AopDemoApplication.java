package com.springframework.aopdemo;

import com.springframework.aopdemo.DAO.AccountDAO;
import com.springframework.aopdemo.DAO.MembershipDAO;
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
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO){

		return runner -> {
			// System.out.println("Hello, world!");
			demoTheBeforeAdvice(theAccountDAO, theMembershipDAO);
		};
	}

	private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();

		// call the account dao getter/setter methods
		theAccountDAO.setName("name");
		theAccountDAO.setServiceCode("serviceCode");

		theAccountDAO.getName();
		theAccountDAO.getServiceCode();

		// call the membership business method
		// theMembershipDAO.addAccount();
		theMembershipDAO.addNewMethod();
		theMembershipDAO.goToSleep();

		// do it again
		// System.out.println("\n Let's call it again! \n");

		// call the business method again
		// theAccountDAO.addAccount();
	}

}
