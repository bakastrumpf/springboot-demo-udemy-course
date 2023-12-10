package com.springframework.boot.restapis.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.boot.restapis.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	// define endpoint for "/students" to return a list of all students
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> theStudents = new ArrayList<>();
		theStudents.add(new Student("Elena", "Galli"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Guido", "Serafino"));
		theStudents.add(new Student("Marco", "Pedrini"));
		return theStudents;
	}

}
