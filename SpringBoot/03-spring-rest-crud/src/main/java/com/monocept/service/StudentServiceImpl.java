package com.monocept.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Student;
import com.monocept.repository.StudentRepository;
import com.monocept.service.StudentService;

import jakarta.transaction.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Override
	public List<Student> getAllStudents() {
		return studentRepo.getAllStudents();
	}

	@Override
	public Student getStudent(int rollNumber) {
		return studentRepo.getStudent(rollNumber);
	}

	@Override
	@Transactional
	public void save(Student student) {
		studentRepo.save(student);
	}

	@Override
	@Transactional
	public void delete(int rollNumber) {
		studentRepo.delete(rollNumber);
	}

	@Override
	@Transactional
	public void update(Student student) {
		studentRepo.update(student);
	}

}
