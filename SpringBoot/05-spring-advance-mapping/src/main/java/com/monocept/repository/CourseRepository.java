package com.monocept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	
}
