package com.springframework.boot.restapis.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.restapis.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	// define @PostConstruct to load the student data only once
	@PostConstruct
	public void loadData() {
		
		theStudents = new ArrayList<>();
		
		// populate theStudents
		theStudents.add(new Student("Elena", "Galli"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Guido", "Serafino"));
		theStudents.add(new Student("Marco", "Pedrini"));
		theStudents.add(new Student("Mirko", "Raimo"));
		theStudents.add(new Student("Alessio", "Mugnaioli"));
		theStudents.add(new Student("Luca", "Giovanelli"));
		theStudents.add(new Student("Daniele", "Dallosso"));
	}
	
	// define endpoint for "/students" to return a list of all students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		// when we use the @PostConstruct to load data, we can only return the results here 
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// just index into the list | to keep it simple for now
		
		// check the studentId again list size
		if ( (studentId >= theStudents.size()) || (studentId < 0) ) {
			throw new StudentNotFoundException("Student ID not found: " + studentId);
		}
		
		return theStudents.get(studentId);
	}
	
	// add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		
		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		
		// return ResponseEntity		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
