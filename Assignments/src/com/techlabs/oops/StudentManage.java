package com.techlabs.oops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class StudentManage {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter Student Details Name, Roll & MailId");
		
		String name = reader.readLine();
		int rollNo = Integer.parseInt(reader.readLine());
		String mailId = reader.readLine();
		
		
		if(validateEmail(mailId)) {
			System.out.println("Student created with");
			Student s = new Student(rollNo,name,mailId);
			s.display();
		}else {
			System.out.println("Enter valid email");
		}
		
		
	}
	
	 public static boolean validateEmail(String email) {
	        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z]+.com+$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        return matcher.matches();
	    }

}
