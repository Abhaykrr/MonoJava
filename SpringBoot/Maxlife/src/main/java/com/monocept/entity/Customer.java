package com.monocept.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="customer_sequence")
	@SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence", initialValue = 10101)
	private int customerid;
	@Column
	private String firstname;
	@Column
	private String lastname;
	@Column
	private int age;
	@Column
	private String email;
	@Column
	private int mobile;
	@Column
	private String street;
	@Column 
	private String state;
	@Column
	private String city;
	@Column
	private int zipcode;
	@Column
	private String nominee;
	@Column
	private String nomineerelation;
	
//	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.ALL},fetch = FetchType.EAGER ,orphanRemoval = true)// persisit nhi tha
//	@JoinColumn(name = "customer_id")
//	private List<InsurancePolicy> insurancepolicy;
	
}
