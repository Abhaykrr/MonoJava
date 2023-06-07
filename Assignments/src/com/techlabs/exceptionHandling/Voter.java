package com.techlabs.exceptionHandling;

public class Voter {

	private int vId;
	private int age;
	
	public Voter(int vId, int age) throws AgeNotValidException {
		super();
		this.vId = vId;
		
		if(age<18) throw new AgeNotValidException(age);
		this.age = age;
	}
	public int getvId() {
		return vId;
	}
	public void setvId(int vId) {
		this.vId = vId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) throws AgeNotValidException {
		if(age<18) throw new AgeNotValidException(age);
		this.age = age;
	}
	
	public  String toString() {
		return "VID :"+vId +" Age : " +age;
	}
	
	
}
