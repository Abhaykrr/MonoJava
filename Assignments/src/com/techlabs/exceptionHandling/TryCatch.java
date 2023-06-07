package com.techlabs.exceptionHandling;

public class TryCatch {
 // PropogationOf EXCEPTION
	
	public static void main(String[] args) {
		int a=0;
		try {
			a=1;
			 a = 10/0;
			
		}catch(ArithmeticException e) {
			System.out.println("Cant Divide by Zero");
		}finally {
			System.out.println("Inside Finally");
		}
		
		System.out.println(a);
	}

}
