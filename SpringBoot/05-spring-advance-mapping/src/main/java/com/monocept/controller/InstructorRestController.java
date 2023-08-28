package com.monocept.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.monocept.entity.Course;
import com.monocept.entity.Instructor;
import com.monocept.service.InstructorService;

@RestController
@RequestMapping("/instructorapp")
public class InstructorRestController {
	
	@Autowired 
	private InstructorService instructorservice;

	
	@PostMapping("/save")
	public void save(@RequestBody Instructor instructor) {
		instructorservice.save(instructor);
	}
	
	@GetMapping("/instructorcources/{firstname}")
	public List<Course> getCourse(@PathVariable( name = "firstname") String firstname){
		return instructorservice.getInstructorCourses(firstname);
	}
	
	@PutMapping("/addcourse/{courseID}")
	public void addCoursesToInstructor(@RequestBody Instructor instructor,@PathVariable(name = "courseID") int courseId) {
		instructorservice.addCourseToInstructor(instructor,courseId);
	}
	
	@DeleteMapping("/deletecourse")
	public void deleteCoursesFromInstructor(@RequestBody Instructor instructor) {
		instructorservice.deleteInstructorCourse(instructor);
	}

}
