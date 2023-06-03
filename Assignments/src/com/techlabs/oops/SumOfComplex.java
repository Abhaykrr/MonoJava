package com.techlabs.oops;

public class SumOfComplex {
	
	public static void main(String[] args) {
		
		Complex num1 = new Complex(2,3);
		Complex num2 = new Complex(3,2);
		Complex  ans = add(num1,num2);
		
		
		
		System.out.println(ans.getNumPart() + "+"+ans.getImaginaryPart()+"i");

	}
	
	static  Complex add(Complex num1,Complex num2) {
		Complex ans = new Complex(0,0);
		
		ans.setNumPart(num1.getNumPart()+num2.getNumPart());
		ans.setImaginaryPart(num1.getImaginaryPart()+num2.getImaginaryPart());
		
		return ans;
	}

}

class Complex {
	
	private int numPart;
	private int imaginaryPart;
	
	Complex(int numPart, int imaginaryPart){
		this.numPart = numPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	Complex(){
		
	}

	public int getNumPart() {
		return numPart;
	}

	public void setNumPart(int numPart) {
		this.numPart = numPart;
	}

	public int getImaginaryPart() {
		return imaginaryPart;
	}

	public void setImaginaryPart(int imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}
	
	

	
}
