package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Course;
import com.monocept.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;

	@Override
	public void save(Course course) {
		courseRepo.save(course);
	}

	@Override
	public List<Course> allCourses() {
		return courseRepo.findAll();
	}
	
	
}
