package com.techlabs.controlstructures;

import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome to treasure Island");
		System.out.println(" Choose left or right");
		
		String des = sc.nextLine();
		
		if(!des.equals("left")) {
			System.out.println("Fall into a hole Game Over");
			System.exit(0);
		}
		
		
		System.out.println("Choose swim or wait");
		des = sc.nextLine();
		
		if(!des.equals("wait")) {
			System.out.println("Attacked by trout Game Over");
			System.exit(0);
		}
		
		
		System.out.println("Choose door Red Blue or Yellow");
		des = sc.nextLine();
		
		if(des.equals("red"))
			System.out.println("Burned by fire Game Over");
		else if(des.equals("blue"))
			System.out.println("Eaten by beats Game Over");
		else if(des.equals("yellow"))
			System.out.println("you win");
		else
			System.out.println("Game Over");
		
		

	}

}
