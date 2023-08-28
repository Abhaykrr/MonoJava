package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monocept.entity.Course;
import com.monocept.service.CourseService;

@RestController
@RequestMapping("/course")
public class CourseRestController {
	
	@Autowired
	private CourseService courseService;
	
	
	@PostMapping("/addcourse")
	public void addCourse(@RequestBody Course course) {
		courseService.save(course);
	}
	
	@GetMapping("/allcourses")
	public List<Course> allCourses(){
		System.out.println(courseService.allCourses());
		return courseService.allCourses();
	}

}
