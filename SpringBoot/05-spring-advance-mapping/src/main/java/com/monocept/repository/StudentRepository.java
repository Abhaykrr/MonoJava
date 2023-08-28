package com.monocept.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monocept.entity.Student;

public interface StudentRepository  extends JpaRepository<Student,Integer>{

	List<Student> findByAddressCity(String city);
	
	List<Student> findByAddressPincode(int pincode);
	
	Student findByFirstname(String firstname);
	
	List<Student> findByAddressArea(String area);
	
	List<Student> findByLastname(String lastname);
	
}
