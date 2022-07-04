package com.classpath.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.classpath.mvc.dao.StudentDAO;
import com.classpath.mvc.model.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;


	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;

	}

	@Transactional
	public void addStudent(Student student) {
		studentDAO.addStudent(student);

	}

	@Transactional
	public List<Student> getAllStudents() {
		return studentDAO.getAllStudents();		

	}

	@Transactional
	public void deleteStudent(Integer studID) {
		studentDAO.deleteStudent(studID); 

	}

	public Student getStudent(Integer studentID) {
		return studentDAO.getStudent(studentID);	

	}


	public Student updateStudent(Student student) {
		return studentDAO.updateStudent(student);

	}



}
