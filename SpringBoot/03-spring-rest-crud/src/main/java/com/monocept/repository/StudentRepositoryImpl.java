package com.monocept.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentRepositoryImpl implements StudentRepository{

	@Autowired
	private EntityManager manager;
	
	@Override
	public List<Student> getAllStudents() {
		TypedQuery<Student> query = manager.createQuery("select students from Student students", Student.class);
		
		return query.getResultList();
	}

	@Override
	public Student getStudent(int rollNumber) {
		Student student = manager.find(Student.class, rollNumber);
		return student;
	}

	@Override
	public void save(Student student) {
		manager.persist(student);
	}

	@Override
	public void delete(int rollNumber) {
		Student student = manager.find(Student.class, rollNumber);
		manager.remove(student);
	}

	@Override
	public void update(Student student) {
	
	 Student existingStudent = manager.find(Student.class, student.getRollnumber());
		    
		  existingStudent.setFirstname(student.getFirstname());
		  existingStudent.setLastname(student.getLastname());
		  existingStudent.setEmail(student.getEmail());
		  manager.merge(existingStudent);
	}

}
