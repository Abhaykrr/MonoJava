package com.techlabs.innerClass;

public class MemberInnerClass {
	
//	Java Inner Classes
	
//	Java inner class or nested class is a class 
//	that is declared inside the class or interface.
	
//	Logically grouping the classes only used in place
//	Increases Encapsulation
//  More Readable	
	
//	Member , Inner , Local Inner class.
	
	
	
/*	A non-static class that is created inside a class 
	but outside a method is called member inner class.
	It is also known as a regular inner class. 
	It can be declared with access modifiers 
	like public, default, private, and protected. */

	public static void main(String[] args) {
		
		Outer outer = new Outer();
		Outer outer1 = new Outer();
		
		Outer.Inner  inner = outer.new Inner();
		Outer.Inner  inner1 = outer1.new Inner();
		
		
		Outer.Inner  inner2 = new Outer().new Inner();
//		Outer.Inner d = new Outer.Inner();

		inner.display();
		inner2.display();
		
	}

}

class Outer{
	
	int a=10;
	private int b= 20;
	static int c= 30;

	
	 class Inner{
		
		void display() {
			System.out.println("Sum is "+(a+b+c+d));
			a++;
			b++;
			c++; 
			d++;
		}
	}
	
	int d =10;
	
//	display(); // Not Possible
}
