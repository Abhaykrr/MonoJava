package com.techlabs.staticdemo;

public class StaticBlock {
	
	static class Hello{
		
	}
	
	static {
		System.out.println("static block");
	}

	static int a =initialize();
	
	public static void main(String[] args) {
		
		Demo d = new Demo();
		
		Hello h =new Hello();
	}

	 static int initialize() {
		System.out.println("I am static method ");
		return 20;
	}+

}


