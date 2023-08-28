package com.monocept.service;

import java.util.List;

import com.monocept.entity.Course;
import com.monocept.entity.Student;

public interface StudentService {

	void save(Student studnet);
	List<Student> studentOfCity(String city);
	List<Student> studentOfPincode(int pincode);
	void deleteStudentOfPincode(int pincode);
	void updateStudentCityToPune(String firstname);
	List<Student> allStudents();
	List<Course> studentCourses(String firstname);
	
	void addCourse(Student student, int courseId);
}
