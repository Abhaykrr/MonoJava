package com.monocept.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

	Instructor findByInstructorname(String name);
}
