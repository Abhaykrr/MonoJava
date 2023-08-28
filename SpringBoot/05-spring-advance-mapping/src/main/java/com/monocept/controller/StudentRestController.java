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

import com.monocept.entity.Course;
import com.monocept.entity.Student;
import com.monocept.service.StudentService;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor	
@RequestMapping("/studentapp1")
public class StudentRestController {

	@Autowired
	private StudentService studentService;
	
	
	@GetMapping("/allstudents")
	public List<Student> allStudents(){
		return studentService.allStudents();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Student student) {
		studentService.save(student);
	}
	
	@GetMapping("/findstudent/city/{cityname}")
	public List<Student> studentOfCity(@PathVariable(name = "cityname") String city){
		return studentService.studentOfCity(city);
	}
	
	@GetMapping("/findstudent/pincode/{pincode}")
	public List<Student> studentOfPincode(@PathVariable(name = "pincode") int pincode){
		return studentService.studentOfPincode(pincode);
	}
	
	@DeleteMapping("/deleteStudents/pincode/{pincode}")
	public void deleteStudentsOfPincode(@PathVariable(name = "pincode") int pincode) {
		studentService.deleteStudentOfPincode(pincode);
	}
	
	@PutMapping("/updatestudentcity/{firstname}")
	public void updateStudentCityToPune(@PathVariable(name = "firstname") String firstname) {
		studentService.updateStudentCityToPune(firstname);
	}
	
	@GetMapping("/courses/{firstname}")
	public List<Course> studentCourses(@PathVariable(name = "firstname") String firstname){
		return studentService.studentCourses(firstname);
	}
	
	@PutMapping("/addcourse/{courseId}")
	public void addCourse(@RequestBody Student student ,@PathVariable(name = "courseId") int courseId) {
		studentService.addCourse(student, courseId);
	}
}
