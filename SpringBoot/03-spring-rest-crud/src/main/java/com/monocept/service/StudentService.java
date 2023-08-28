package com.monocept.service;

import java.util.List;

import com.monocept.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	Student getStudent(int rollNumber);
	void save(Student student);
	void delete(int rollNumber);
	void update(Student student);

}
