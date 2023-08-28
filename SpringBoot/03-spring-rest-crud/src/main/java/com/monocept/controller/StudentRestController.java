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

import com.monocept.entity.Student;
import com.monocept.service.StudentService;

@RestController
@RequestMapping("/studentapp")
public class StudentRestController {

	@Autowired
	private StudentService studentServive;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentServive.getAllStudents();
	}
	
	@GetMapping("/getstudent/{rollNumber}")
	public Student getStudent(@PathVariable(name = "rollNumber") int rollNumber) {
		return studentServive.getStudent(rollNumber);
	}
	
	@PostMapping("/poststudent")
	public void save(@RequestBody Student student) {
		studentServive.save(student);
	}
	
	@DeleteMapping("/deletestudent/{rollNumber}")
	public void delete(@PathVariable(name = "rollNumber") int rollNumber) {
		studentServive.delete(rollNumber);
	}
	
	@PostMapping("/deletestudent/{rollNumber}")
	public void deletee(@PathVariable(name = "rollNumber") int rollNumber) {
		studentServive.delete(rollNumber);
	}
	
	@PutMapping("/updatestudent")
	public void update(@RequestBody Student student) {
		studentServive.update(student);
	}
}
