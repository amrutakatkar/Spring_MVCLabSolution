package com.classpath.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.classpath.mvc.model.Student;
import com.classpath.mvc.service.StudentService;

@Controller
public class StudentController {

	public StudentController() {
		System.out.print("StudentController");
	}

	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/")
	public ModelAndView listStudent(ModelAndView model) throws IOException{

		List<Student> listStudent = studentService.getAllStudents();
		model.addObject("students",listStudent);
		model.setViewName("home");
		return model;		
	}


	@RequestMapping(value = "/newStudent", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Student student = new Student();
		model.addObject(student);
		model.setViewName("StudentForm");
		return model;		
	}


	@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Student student) {	
		if (student.getId()==0) { 
			studentService.addStudent(student);		  
		} 
		else 
		{
			studentService.updateStudent(student);
		}		  
		return new ModelAndView("redirect:/");			
	}


	@RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
	public ModelAndView deleteStudent(HttpServletRequest request) {		  
		int studID = Integer.parseInt(request.getParameter("id"));	     
		studentService.deleteStudent(studID);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editStudent", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int studentId = Integer.parseInt(request.getParameter("id"));
		Student student = studentService.getStudent(studentId);
		ModelAndView model = new ModelAndView("StudentForm");
		model.addObject("student", student);	 
		return model;
	}
}
