package com.techlabs.interface1;

public class Circle implements Shape{

	private double radius;
	
	
	public Circle(double radius) {
		this.radius=radius;
	}
	
	public void area() {
	  System.out.println("circle area");
	}
	
	public void description() {
		System.out.println("circle desc");
	}
	
}

