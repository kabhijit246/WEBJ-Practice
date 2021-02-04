package com.beehyv.assignment.springJdbcAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/student")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@RequestMapping
	public String get() {
		return "Welcome to the World of Spring JDBC";
	}
	
	@GetMapping(path="/first-name")
	public String getFirst(){
		return String.format("Students First Name: %s", studentRepo.getFirstName());
	}
	
	@GetMapping(path="/last-name")
	public String getLast(){
		return String.format("Students Last Name: %s", studentRepo.getLastName());
	}
}
