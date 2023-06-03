package com.techlabs.enums;

import java.util.Scanner;

public class ArrayPatients {

	public static void main(String[] args) {
		Scanner scanner =new Scanner(System.in);
		
		Patient patients[] = new Patient[5];
		
		for(int i=0;i<5;i++) {
			System.out.println("Enter Name ");
			String name = scanner.next();
			System.out.println("Enter bpLevel High/Low/Normal");
			String bpLevel = scanner.next();
			
			patients[i] = new Patient(name,BpLevel.valueOf(bpLevel));
		}
		
		for(int i=0;i<5;i++)
			System.out.println(patients[i]);
		
		
		
	}

}
