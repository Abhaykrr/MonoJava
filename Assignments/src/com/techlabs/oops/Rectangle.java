package com.techlabs.oops;

public class Rectangle {

	
	private	int length;
	private	int height;
	
	
	private Rectangle(){ // obj cannot be created
		
	}
	
	Rectangle(int length, int height){
		this.length = length;
		this.height = height;
	}
	
	public void accept(int length,int height) {
		this.length = length;
		this.height = height;
	}
	
	void display() {
		System.out.println("Height " +height);
		System.out.println("Length " +length);
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	
}
