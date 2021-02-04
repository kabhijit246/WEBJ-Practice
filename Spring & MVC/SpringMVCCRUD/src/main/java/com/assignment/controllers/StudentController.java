package com.assignment.controllers;   

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;
import com.assignment.beans.Student;
import com.assignment.dao.StudentDao;  

@Controller  
public class StudentController {  
	@Autowired  
	StudentDao dao;

	@RequestMapping("/studentform")  
	public String showform(Model m){  
		m.addAttribute("command", new Student());
		return "studentform"; 
	}  

	@RequestMapping(value="/save",method = RequestMethod.POST)  
	public String save(@ModelAttribute("st") Student st){  
		dao.save(st);  
		return "redirect:/viewstudent";
	}  

	@RequestMapping("/viewstudent")  
	public String viewemp(Model m){  
		List<Student> list=dao.getStudents();  
		m.addAttribute("list", list);
		return "viewstudent";  
	}  

	@RequestMapping(value="/editstudent/{id}")  
	public String edit(@PathVariable int id, Model m){  
		Student st=dao.getStudentById(id);  
		m.addAttribute("command", st);
		return "studenteditform";
	}  

	@RequestMapping(value="/editsave",method = RequestMethod.POST)  
	public String editsave(@ModelAttribute("st") Student s){  
		dao.update(s);  
		return "redirect:/viewstudent";
	} 

	@RequestMapping(value="/deletestudent/{id}",method = RequestMethod.GET)  
	public String delete(@PathVariable int id){  
		dao.delete(id);  
		return "redirect:/viewstudent";
	}   
}  