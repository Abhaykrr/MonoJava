package com.techlabs.oops;

import java.util.Scanner;

public class EmpManage {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter user details eid,name and salary");
		
		int eid = scanner.nextInt();
		String ename = scanner.next();
		int salary = scanner.nextInt();
		
		Employee emp = new Employee(eid,ename,salary);
		
//		emp.display();
		
		System.out.println("Employee id "+emp.getEid());
		System.out.println("Employee name "+emp.getEname());
		System.out.println("Employee salary " +emp.getSalary());

	}

}
