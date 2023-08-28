package com.monocept.service;

import java.util.List;
import java.util.logging.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Address;
import com.monocept.entity.Course;
import com.monocept.entity.Student;
import com.monocept.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
@Slf4j
public class StudentServiceIMPL implements StudentService{
	
//	private static final Logger log = LoggerFactory.getILoggerFactory().getClass(StudentServiceIMPL.class);

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private CourseService courseService;
	
	@Override
	public void save(Student studnet) {
		studentRepo.save(studnet);
		System.out.println("Student Inserted Successfully");
	}

	@Override
	public List<Student> studentOfCity(String city) {
		return studentRepo.findByAddressCity(city);
	}

	@Override
	public List<Student> studentOfPincode(int pincode) {
		return studentRepo.findByAddressPincode(pincode);
	}

	@Override
	@Transactional
	public void deleteStudentOfPincode(int pincode) {
		List<Student> student = studentRepo.findByAddressPincode(pincode);	
		studentRepo.deleteAll(student);
	}

	@Override
	@Transactional
	public void updateStudentCityToPune(String firstname) {
		Student student =  studentRepo.findByFirstname(firstname);
		
		if(student!=null) {
			Address address = student.getAddress();
			address.setCity("pune");
			studentRepo.save(student);
		}else {
			System.out.println("No Student Found");
		}
	}

	@Override
	public List<Student> allStudents() {
		return studentRepo.findAll();
	}

	@Override
	public List<Course> studentCourses(String firstname) {
		Student student =  studentRepo.findByFirstname(firstname);
		return student.getCourses();
	}

	@Override
	public void addCourse(Student student, int courseId) {
		Student actual =  studentRepo.findByFirstname(student.getFirstname());
		
	List<Course> allCourses = courseService.allCourses();
		
		Course toAdd = new Course();
		
		for(int i = 0; i<allCourses.size() ;i++) {
			if(allCourses.get(i).getCourseid() == courseId) {
				toAdd = allCourses.get(i);
				break;
			}
		}
		
		if(actual!=null) {
			actual.getCourses().add(toAdd);
			studentRepo.save(actual);
			System.out.println("Course Added to STUDENT");
		}
	
	}

}
