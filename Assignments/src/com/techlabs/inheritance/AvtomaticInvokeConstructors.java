package com.techlabs.inheritance;

public class AvtomaticInvokeConstructors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		C c = new C();
	}

}

class A{
	
	A(int a){
		System.out.println("Im A");
	}
}

class B extends A{
	
	B(){
		super(10);
		System.out.println("Im B");
	}
}

class C extends B{
	
	C(){
		System.out.println("Im C");
	}
}
