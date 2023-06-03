package com.techlabs.enums;

import java.util.Scanner;

public class ManagePatient {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Name ");
		String name = scanner.next();
		System.out.println("Enter bpLevel High/Low/Normal");
		String bpLevel = scanner.next();
		
		Patient p = new Patient(name,BpLevel.valueOf(bpLevel));
		System.out.println(p);
		
	}

}
