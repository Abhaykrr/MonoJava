package com.monocept.dao;

import java.util.List;

import com.monocept.entity.*;

public interface StudentDao {

	void save(Student student);
	Student getStudent(int rollnumber);
	List<Student> getAllStudents();
	void updateStudent(Student student, int rollnumber);
	void deleteStudentByRollNumber(int rollnumber);
}
