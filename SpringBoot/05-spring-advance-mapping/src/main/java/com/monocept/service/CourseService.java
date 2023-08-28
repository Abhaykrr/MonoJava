package com.monocept.service;

import java.util.List;

import com.monocept.entity.Course;

public interface CourseService {

	void save(Course course);
	List<Course> allCourses();
}
