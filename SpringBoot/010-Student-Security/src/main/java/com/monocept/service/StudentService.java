package com.monocept.service;

import java.util.List;

import com.monocept.entity.Student;

public interface StudentService {
	
	List<Student> getAllStudents();
	void save(Student student);


}
