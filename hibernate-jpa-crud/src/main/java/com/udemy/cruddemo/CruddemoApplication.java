package com.udemy.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.udemy.cruddemo.Entity.Student;
import com.udemy.cruddemo.dao.StudentDAO;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
		
		@Bean
		public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
			
			return runner -> {
				//System.out.println("Hello, world!");
				createStudent(studentDAO);
			};
		}
		
		private void createStudent(StudentDAO studentDAO) {
			
			// create the student object
			System.out.println("Creating new student object... ");
			Student tempStudent = new Student("Paul", "Thestudent", "paul@thestudent.net");
			
			// save the student object
			System.out.println("Saving the student... ");
			studentDAO.save(tempStudent);
			
			// display id of the saved student
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
		}

}
