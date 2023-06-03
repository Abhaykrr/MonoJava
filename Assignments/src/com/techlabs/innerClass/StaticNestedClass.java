package com.techlabs.innerClass;

public class StaticNestedClass {

	public static void main(String[] args) {
		
		 TestOuter.Inner obj=new TestOuter.Inner();  
		  obj.msg();  
	}

}

class TestOuter{  
	  static int data=30;  
	  
	  static class Inner{  
	   void msg(){System.out.println("data is "+data);}  
	  }  
	  
}