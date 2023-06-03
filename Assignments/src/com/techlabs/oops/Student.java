package com.techlabs.oops;

public class Student {
	
	private int rollNo;
	private String name;
	private String email;
	
	
	Student(int rollNo,String name, String email){
		this.rollNo = rollNo;
		this.name = name;
		this.email = email;
	}


	public int getRollNo() {
		return rollNo;
	}


	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	public void display() {
		System.out.println("Student Details : ");
		System.out.println("Name   : " +name);
		System.out.println("RollNo : " +rollNo);
		System.out.println("MailId : " +email);
	}

}
