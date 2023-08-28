package com.monocept.dao;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.monocept.entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class Dao_IMP implements StudentDao{
	
	private EntityManager manager;
	
	@Autowired
	public Dao_IMP(EntityManager manager) {
		this.manager = manager;
	}
	
	
	@Override
	@Transactional
	public void save(Student student) {
	    try {
	        manager.persist(student);
	        System.out.println("Student Inserted Successfully");
	    } catch (Exception e) {
	        System.out.println("Error occurred while saving student: " + e.getMessage());
	    }
	}

	@Override
	public Student getStudent(int rollnumber) {
	    try {
	        Student student = manager.find(Student.class, rollnumber);
	        return student;
	    } catch (Exception e) {
	        System.out.println("Error occurred while retrieving student: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public List<Student> getAllStudents() {
	    try {
	        TypedQuery<Student> query = manager.createQuery("select students from Student students", Student.class);
	        return query.getResultList();
	    } catch (Exception e) {
	        System.out.println("Error occurred while retrieving all students: " + e.getMessage());
	        return Collections.emptyList();
	    }
	}

	@Override
	@Transactional
	public void updateStudent(Student student, int rollnumber) {
	    try {
	        Student existingStudent = manager.find(Student.class, rollnumber);
	        if (existingStudent != null) {
	            existingStudent.setFirstname(student.getFirstname());
	            existingStudent.setLastname(student.getLastname());
	            existingStudent.setEmail(student.getEmail());
	            manager.merge(existingStudent);
	        }
	    } catch (Exception e) {
	        System.out.println("Error occurred while updating student: " + e.getMessage());
	    }
	}

	@Override
	@Transactional
	public void deleteStudentByRollNumber(int rollnumber) {
	    try {
	        Student student = manager.find(Student.class, rollnumber);
	        if (student != null) {
	            manager.remove(student);
	        }
	    } catch (Exception e) {
	        System.out.println("Error occurred while deleting student: " + e.getMessage());
	    }
	}
}