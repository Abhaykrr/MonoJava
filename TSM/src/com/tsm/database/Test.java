package com.tsm.database;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		DbConnection dbConnection = DbConnection.getConnection();
		
//		DbConnection.createCompanyDb();
		DbConnection.createDepartmentTable();
		DbConnection.createEmployeeTable();
		dbConnection.connect();

		
		 boolean exit = false;
	        while (!exit) {
	            System.out.println("\nMenu:");
	            System.out.println("1. Add Department");
	            System.out.println("2. Add Employee");
	            System.out.println("3. Search Employees by Department");
	            System.out.println("4. Show All Employees");
	            System.out.println("5. Show All Departments");
	            System.out.println("6. Increase Employee Commissions");
	            System.out.println("7. Delete Employees by Salary");
	            System.out.println("8. Exit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    dbConnection.addDepartment();
	                    break;
	                case 2:
	                    dbConnection.addEmployee();
	                    break;
	                case 3:
	                    dbConnection.searchByDepartment();
	                    break;
	                case 4:
	                    dbConnection.showAllEmployees();
	                    break;
	                case 5:
	                    dbConnection.showAllDepartments();
	                    break;
	                case 6:
	                    dbConnection.increaseCommission();
	                    break;
	                case 7:
	                    dbConnection.deleteEmployeesBySalary();
	                    break;
	                case 8:
	                    exit = true;
	                    System.out.println("Exiting the program...");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	}

}
