package com.techlabs.typecasting;

public class Widening_Conversion {

	public static void main(String[] args) {
		
		
		// Automatic type casting
		int a =10;
		double b= 10.5;
		
		float c=10.5f;
		
		byte d =10;
		
		byte e=(byte) (d*a); // narrowing
		
		int f=30;
		Integer fobj =f; // autoboxing
		
		int g = fobj; // unboxing
		
		
		
		
	}

}
