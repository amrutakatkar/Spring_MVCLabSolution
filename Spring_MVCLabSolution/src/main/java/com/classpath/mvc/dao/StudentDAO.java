package com.classpath.mvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.classpath.mvc.model.Student;

@Repository
public class StudentDAO {

	@Autowired 
	private SessionFactory sessionFactory;


	@SuppressWarnings("unchecked")
	public List<Student> getAllStudents() {
		return sessionFactory.getCurrentSession().createQuery("from Student").list();
	}

	public void addStudent(Student student) {	
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}



	public Student getStudent(Integer studentID) {		
		Student student = (Student) sessionFactory.getCurrentSession().get(Student.class, studentID);

		return student;
	}

	public Student updateStudent(Student student) {		
		sessionFactory.getCurrentSession().update(student);		
		return student;

	}

	public void deleteStudent(Integer studID) {		
		Student student = (Student) sessionFactory.getCurrentSession().load(Student.class, studID);		
		if(null!= student) {			
			this.sessionFactory.getCurrentSession().delete(student);

		}
	}


}
