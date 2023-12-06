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
				// System.out.println("Hello, world!");
				// createStudent(studentDAO);
				
				createMultipleStudents(studentDAO);
			};
		}
		
		private void createMultipleStudents(StudentDAO studentDAO) {
			
			// create multiple students
			
			System.out.println("Creating 3 student objects... ");
			Student tempStudent1 = new Student("Melissa", "Thestudent", "melissa@thestudent.net");
			Student tempStudent2 = new Student("James", "Estudante", "james@estudante.net");
			Student tempStudent3 = new Student("Janet", "Studente", "janet@studente.net");
			
			// save the student objects
			
			System.out.println("Saving the students... ");
			studentDAO.save(tempStudent1);
			studentDAO.save(tempStudent2);
			studentDAO.save(tempStudent3);
			
		}
	
		
		private void createStudent(StudentDAO studentDAO) {
			
			// create the student object
			System.out.println("Creating new student object... ");
			Student tempStudent0 = new Student("Paul", "Thestudent", "paul@thestudent.net");
			
			// save the student object
			System.out.println("Saving the student... ");
			studentDAO.save(tempStudent0);
			
			// display id of the saved student
			System.out.println("Saved student. Generated id: " + tempStudent0.getId());
		}

}
