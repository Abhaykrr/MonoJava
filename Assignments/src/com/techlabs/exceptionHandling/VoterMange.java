package com.techlabs.exceptionHandling;

public class VoterMange {

	public static void main(String[] args) {
		
		Voter voter =null;
		
		try {
			 voter = new Voter(101,12);
		}catch(AgeNotValidException e){
			System.out.println(e);
		}
		try {
			voter.setAge(20);
		}catch(AgeNotValidException e) {
			System.out.println(e);
		}
//		System.out.println(voter);
	}

}
