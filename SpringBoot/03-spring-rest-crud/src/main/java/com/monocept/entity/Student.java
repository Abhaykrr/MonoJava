package com.monocept.entity;
	
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="rollnumber")
	private int rollnumber;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="email")
	private String email;
	
	
	public Student() {
		super();
	}


	public Student(String firstname, String lastname, String email) {
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}


	public int getRollnumber() {
		return rollnumber;
	}


	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
	    return "[rollnumber= " + rollnumber + ", firstname= " + firstname + "]";
	}

	
	
	
	
	

}
