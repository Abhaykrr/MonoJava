package com.techlabs.iterativeStatements;

public class PrimeBetRange {
	
	public static void main(String[] args) {
		
		int number;
		
		for(int j=2;j<=100;j++) {
			
			number=j;
			int ifprime=1;
			for(int i=2 ;i*i<number;i++) {
				if(number%i==0) {
					ifprime = 0;
					break;
				}
				
			}
			
			if(ifprime==1)System.out.println(+j +" is a Prime Number");
		}
		
	}

}
