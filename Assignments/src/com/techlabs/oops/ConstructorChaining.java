package com.techlabs.oops;

public class ConstructorChaining {

	public static void main(String[] args) {
		
		Rectanglee r = new Rectanglee();
		
		System.out.println(r.getHeight());
		System.out.println(r.getWidth());
	}

}

class Rectanglee{
	
	private int height;
	private int width;
	
	Rectanglee(int height, int width){
		this.height = height;
		this.width = width;
	}
	
	Rectanglee(){
		this(5);
	}
	
	Rectanglee(int height){
		this(height,0);
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
	
	
	
}
