package com.udemy.cruddemo;

import java.util.List;

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
				// createMultipleStudents(studentDAO);
				// readStudent(studentDAO);
				// queryForStudents(studentDAO);
				// queryForStudentsByLastName(studentDAO);
				// updateStudent(studentDAO);
				// deleteStudent(studentDAO);
				deleteAllStudents(studentDAO);
			};
		}
		
		private void deleteAllStudents(StudentDAO studentDAO) {
			
			// delete all students
			System.out.println("Deleting all students. ");
			int numRowsDeleted = studentDAO.deleteAllStudents();
			System.out.println("Deleted row count: " + numRowsDeleted);
			
		}

		private void deleteStudent(StudentDAO studentDAO) {

			// delete the student
			int studentId = 3;
			System.out.println("Deleting student id: " + studentId);
			studentDAO.delete(studentId);
			
		}

		private void updateStudent(StudentDAO studentDAO) {
			
			// retrieve student based on the id: primary key
			int studentId = 1;
			System.out.println("Getting student with id: " + studentId);
			Student myStudent = studentDAO.findById(studentId);
			
			// change first name to "sth"
			System.out.println("Updating student... ");
			// myStudent.setFirstName("Scooby");
			myStudent.setFirstName("Mary");
			
			// update the student
			studentDAO.update(myStudent);			
			
			// display the updated student			
			System.out.println("Updated student: " + myStudent);
			
		}

		private void queryForStudentsByLastName(StudentDAO studentDAO) {
			
			// get a list of students
			List<Student> theStudents = studentDAO.findByLastName("Estudante");
			
			// display list of students			
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			} 	
		}

		private void queryForStudents(StudentDAO studentDAO) {
			
			// get a list of students
			List<Student> theStudents = studentDAO.findAll();
						
			// display list of students			
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
		}
		
		private void readStudent(StudentDAO studentDAO) {
			
			// create a student object
			System.out.println("Creating new student object... ");
			Student tempStudent4 = new Student("Thenew", "Stud", "thenew@stud.com");
			
			// save the student object
			System.out.println("Saving the student... ");
			studentDAO.save(tempStudent4);
			
			// display id of the saved student
			int theId = tempStudent4.getId();
			System.out.println("Saved student. Generated id: " + theId);
			
			// retrieve student based on the id: primary key
			System.out.println("Retrieving student with id: " + theId);
			Student myStudent = studentDAO.findById(theId);
			
			// display student
			System.out.println("Found the student: " + myStudent);
			
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
