package com.tsm.assignments;

public class Test1 {

//	 public static members of one class can be accessed inside another class ?

//---> A static member of a class  can be accessed inside any other class using the class name.
	
	public static void main(String[] args) {
		
		int a = Demo.a;
		Demo.display();
		
		Demo demo = new Demo();
		System.out.println(demo.a);
	}

}

class AnotherClass{
	public static int b = Demo.a;  
	
	public void generate() {
		Demo demo = new Demo();
		System.out.println(demo.a);
	}
}

class Demo{
	
	public static int a = 10;
	
	public static void display() {
		System.out.println("Hello");
	}
	
}