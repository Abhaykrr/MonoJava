package com.techlabs.operators;

public class Operators {

	public static void main(String[] args) {
//__________________________________________________________________________________	
		// Arithmetic Operators //
		
				/* 
				* : Multiplication
				/ : Division
				% : Modulo
				+ : Addition
				– : Subtraction 
				*/
		
		    int a = 10;  // Assignment operator 
	        int b = 3;
	       
	        System.out.println("a + b = " + (a + b));
	        System.out.println("a - b = " + (a - b));
	        System.out.println("a * b = " + (a * b));
	        System.out.println("a / b = " + (a / b));
	        System.out.println("a % b = " + (a % b));
//____________________________________________________________________________
	        // Logical operator //
	        
	              /*  AND Operator ( && ) 
	        		 OR Operator ( || ) 
	        		 NOT Operator ( ! )  */
	        
	        
	        a=10; b=20; int c = 20, d = 0;
	        
	        if ((a < b) && (b == c)) {
	            d = a + b + c;
	            System.out.println("The sum is: " + d);
	        }
	        else
	            System.out.println("False");
	        
//____________________________________________________________________________
	        
	     // Assignment operator 
	        
	        a=10; b=5;
	        
	        a/=b;
	        a*=b;
	        a=b;
	        a%=b;
//_____________________________________________________________________________________
	        
	        // Relational Operator
	        
	        a=10; b=20;
	        
	        System.out.println(a>b);  // Greater Than
	        System.out.println(a>=b); // Greater than equal to
	        System.out.println(a<=b); // less than equal to
	        System.out.println(a<b);  // less than
	        System.out.println(a==b); // Equal to
	        System.out.println(a!=b); // not equal to
	        
//_______________________________________________________________________________________
	        
	        // Ternary Operator
	        
	        a=6; b=9;
	        
	        int max = (a > b) ? a : b;
	   
	        System.out.println("Maximum is = " + max);
	        
//_________________________________________________________________________________
	        
	        
	        // Bitwise Operators
	        
	        a = 5;
	        b = 7;
	 
	        // bitwise and
	        // 0101 & 0111=0101 = 5
	        System.out.println("a&b = " + (a & b));
	 
	        // bitwise or
	        // 0101 | 0111=0111 = 7
	        System.out.println("a|b = " + (a | b));
	 
	        // bitwise xor
	        // 0101 ^ 0111=0010 = 2
	        System.out.println("a^b = " + (a ^ b));
	        
	        
	        // Shift Operators
	        
	        System.out.println(a>>1); // 0101 >> 1 = 0010 = 2 // Right Shift 
	        System.out.println(a<<1); // 0101 << 1 = 1010 = 10// Left Shift

//___________________________________________________________________________________
	        
	     // unary operator
	        
	        a=3; b=5;
	        System.out.println(++a);
	        System.out.println(a++);
	        System.out.println(a);
	        
	        System.out.println(--b);
	        System.out.println(b--);
	        System.out.println(b);
//_______________________________________________________________________________
	        
	
	}
	

}
