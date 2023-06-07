package com.techlabs.exceptionHandling;

public class AgeNotValidException extends Exception {
	
	int age ;
	AgeNotValidException(int age){
		this.age = age;
	}
	
	public String getMessage() {
		return "age less than 18 you entered" +age;
	}

}
