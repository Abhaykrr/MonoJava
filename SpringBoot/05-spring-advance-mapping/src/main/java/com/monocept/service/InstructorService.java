package com.monocept.service;

import java.util.List;

import com.monocept.entity.Course;
import com.monocept.entity.Instructor;

public interface InstructorService {

	void save(Instructor instructor);
	List<Course> getInstructorCourses(String firstname);
	void addCourseToInstructor(Instructor instructor,int courseId);
	void deleteInstructorCourse(Instructor instructor);
}
