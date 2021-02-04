package com.beehyv.assignment.springJdbcAssignment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentRepo {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<String> getFirstName(){
		List<String> firstName = new ArrayList<String>();
		firstName.addAll(jdbcTemplate.queryForList("SELECT first_name FROM student", String.class));
		return firstName;
	}
	
	public List<String> getLastName(){
		List<String> lastName = new ArrayList<String>();
		lastName.addAll(jdbcTemplate.queryForList("SELECT last_name FROM student", String.class));
		return lastName;
	}
}
