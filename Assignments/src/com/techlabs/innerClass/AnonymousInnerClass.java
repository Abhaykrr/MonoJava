package com.techlabs.innerClass;

public class AnonymousInnerClass {
	
	
/*	Java anonymous inner class is an inner class 
	without a name and for which only a single object 
	is created. An anonymous inner class can be useful 
	when making an instance of an object with certain 
	"extras" such as overloading methods of a class or 
	interface, without having to actually subclass a 
	class. */
	
/*	It should be used if you have to override a 
	method of class or interface. */

	public static void main(String[] args) {
		
		Human h = new Human(){
		   void	display() {
			   System.out.println("I am Custom Human");
			   
		   }
		};
		
		h.display();
		
		Human h2 = new Human();
		h2.display();
	}

}

class Human{
	void display() {
		System.out.println("I am human");
	}
}
