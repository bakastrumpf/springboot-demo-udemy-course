package com.springframework.boot.restapis.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
		theStudents.add(new Student("Elena", "Galli"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Guido", "Serafino"));
		theStudents.add(new Student("Marco", "Pedrini"));
	}
	
	// define endpoint for "/students" to return a list of all students
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		// when we use the @PostConstruct to load data, we can only return the results here 
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		// populate theStudents
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Mirko", "Raimo"));
		theStudents.add(new Student("Alessio", "Mugnaioli"));
		theStudents.add(new Student("Luca", "Giovanelli"));
		theStudents.add(new Student("Daniele", "Dallosso"));
		return theStudents.get(studentId);
	}

}
