package com.techlabs.lambda;

public class StaticTest {

	static void print() {
		System.out.println("Im print od static");
	}
	public static void main(String[] args) {
		
		Tester t = StaticTest::print;
		
		NonStatic non =  new NonStatic();
		
		Tester t1 = non::print;
		  t1=NonStatic::new;
	}

}

class NonStatic{
	NonStatic(){
		
	}
	
	void print() {
		System.out.println("Im inside NonStatic");
	}
}
