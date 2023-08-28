package com.monocept.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Course;
import com.monocept.entity.Instructor;
import com.monocept.repository.InstructorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService{

	
	@Autowired
	private InstructorRepository instructorrepo;
	
	@Autowired
	private CourseService courseService;
	
	@Override
	public void save(Instructor instructor) {
		instructorrepo.save(instructor);
	}

	@Override
	public List<Course> getInstructorCourses(String firstname) {
		Instructor instructor = instructorrepo.findByInstructorname(firstname);
			return instructor.getCourses();
		
	}

	@Override
	public void addCourseToInstructor(Instructor instructor,int courseId) {
		
		Instructor actual = instructorrepo.findByInstructorname(instructor.getInstructorname());
		
		List<Course> allCourses = courseService.allCourses();
		
		Course toAdd = new Course();
		
		for(int i = 0; i<allCourses.size() ;i++) {
			if(allCourses.get(i).getCourseid() == courseId) {
				toAdd = allCourses.get(i);
				toAdd.setInstructor(null);
				break;
			}
		}
		
		if(actual!=null) {
			actual.getCourses().add(toAdd);
			instructorrepo.save(actual);
			System.out.println("Course Added to INSTRUCTOR");
		}
		
	}

	@Override
	public void deleteInstructorCourse(Instructor instructor) {
		
		Instructor actual = instructorrepo.findByInstructorname(instructor.getInstructorname());
		
		
		if(actual!=null) {
//			actual.getCourses().removeAll(instructor.getCourses());
			
			for(int i = 0; i< actual.getCourses().size() ;i ++) {
				if(actual.getCourses().get(i).getCoursename().equals(instructor.getCourses().get(0).getCoursename())) {
					actual.getCourses().remove(i);
				}
			}
			instructorrepo.save(actual);
			System.out.println("Courses Deleted");
		}
	}

	


}
