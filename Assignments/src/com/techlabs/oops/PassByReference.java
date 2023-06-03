package com.techlabs.oops;

public class PassByReference {

	public static void main(String[] args) {
		
		Custom c = new Custom(10,20);
		swap(c);
		System.out.println(c.getA() +" " +c.getB());

	}
	
	static void swap(Custom c) {
		int temp  = c.getA();
		c.setA(c.getB());
		c.setB(temp);
	}

}

 class Custom {
	private int a;
	private int b;
	
	Custom(int a,int b){
		this.a=a;
		this.b=b;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}
	
	
}
