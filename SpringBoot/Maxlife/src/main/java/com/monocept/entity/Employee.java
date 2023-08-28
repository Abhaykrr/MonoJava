package com.monocept.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="employee_sequence")
	@SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence", initialValue = 30301)
	private int employeeid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private String status;
	
}
