package com.techlabs.oops;

public class Test {

	public static void main(String[] args) {
		
		Rectangle r = new Rectangle(10,15);
		
		int area = r.getHeight()*r.getLength();
		
		System.out.println(area);
		
         r.display();
	}

}
