package com.techlabs.innerClass;

public class LocalInnerClass {
	
//	Local Inner Classes are the inner classes that are defined inside a block. 
//	this block can be a for loop, or an if clause.
//	cannot have any access modifiers associated
//	hey can be marked as final or abstract.
//	used when a obj is to be used only inside a block

	public static void main(String[] args) {
		 localInner obj=new localInner();  
		 
				obj.display();
				display();
				
				
				for(int i=0;i<10;i++) {
					
					class loop{
						void display() {
							System.out.println("Im inside a loop");
						}
					}
				}
				
				if(4>10) {
					class iff{
						void display() {
							System.out.println("Im inside a if");
						}
					}
				}
	}

	static void display() {
		
		class Local{
			void display() {
				System.out.println("Im inside local class");
			}
		}
		
		Local local = new Local();
		local.display();
	}
}


 class localInner{  
	 private int data=30;
	 
	 void display(){  
		 
	  class Local{  
	   void msg(){System.out.println(data);}  
	  }  
	  
	  Local l=new Local();  
	  l.msg();  
	 }  
 }
