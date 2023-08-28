package com.monocept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.Student;

public interface StudentRepository  extends JpaRepository<Student, Integer>{

	
}
