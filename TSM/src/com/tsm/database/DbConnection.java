package com.tsm.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DbConnection {
	
	private static DbConnection dbConnection;
	private static Connection connection ;
	
	private static Scanner scanner = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String username = "root";
    private static String password = "root";
    private static String DB_NAME = "COMPANY";
	
	private DbConnection() {}
	
	void connect() {
		
	       
	        try  {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	connection =  DriverManager.getConnection(url+DB_NAME, username, password);
	            System.out.println("Company DB Connected Successfully");
	      
	        	
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	 static void createCompanyDb() {
        try {
        	connection = DriverManager.getConnection(url,username,password);
        	
        	Statement statement = connection.createStatement();
        	
        

            String createDbQuery = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
            int row = statement.executeUpdate(createDbQuery);
    
            if(row>0)
                System.out.println("COMPANY database created successfully.");
            else
            	System.out.println("COMPANY database already exists");
            
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Failed to create company database. Error: " + e.getMessage());
        }
    }
	 
	 static void createDepartmentTable() {
		 
		 try {
			 connection = DriverManager.getConnection(url+DB_NAME,username,password);
	     	 Statement statement = connection.createStatement();
	     	 
	     	 String query = "CREATE TABLE IF NOT EXISTS department("
	     	 		+ "deptno INT PRIMARY KEY AUTO_INCREMENT,"
	     	 		+ "dname VARCHAR(50),"
	     	 		+ "loc VARCHAR(50)"
	     	 		+ ")" ;
	     	 
	     	int row = statement.executeUpdate(query);
	     	
	     		System.out.println("department table created successfully");
	     	
	     		  statement.close();
	              connection.close();
		 }catch(Exception e) {
			 System.out.println("Failed to create department table in database. Error: " + e.getMessage());
		 }
		 
		
		 
	 }
	 
	 static void createEmployeeTable() {
		 try {
			 connection = DriverManager.getConnection(url+DB_NAME,username,password);
	     	 Statement statement = connection.createStatement();
	     	 
	     	 String query = "CREATE TABLE IF NOT EXISTS employee (" +
	                    "empno INT PRIMARY KEY AUTO_INCREMENT," +
	                    "ename VARCHAR(50)," +
	                    "job VARCHAR(50)," +
	                    "manager INT," +
	                    "hiredate DATE," +
	                    "sal DOUBLE," +
	                    "comm DOUBLE," +
	                    "deptno INT" +
	                    ")";
	     	 
	     	int row = statement.executeUpdate(query);
	     
	     		System.out.println("employee table created successfully");
	     
	     		  statement.close();
	              connection.close();
		 }catch(Exception e) {
			 System.out.println("Failed to create employee table in database. Error: " + e.getMessage());
		 }
	 }
	 
	 
	 void addDepartment() {
		 
//		 Department dep = new Department(50, "IT", "MUMBAI");
		 
		 try {
			 String query = "INSERT INTO DEPARTMENT VALUES(DEFAULT,?,?)";
			 PreparedStatement preparedStatement = connection.prepareStatement(query);
			 
			 System.out.print("\nEnter Department Name: ");
			 String dname  = scanner.next();
			 System.out.print("Enter Department Location: ");
			 String loc  = scanner.next();
			 
			 preparedStatement.setString(1, dname);
			 preparedStatement.setString(2, loc);
			 
//			 preparedStatement.setString(1, dep.getDName());
//			 preparedStatement.setString(2, dep.getLoc());
			 
			 preparedStatement.executeUpdate();
			 
			 System.out.println("New Department Added \n");
			 
			 
		 }catch(Exception e) {
			 System.out.println("Failed to add department. Error: " + e.getMessage());
		 }
		
		 
	 }
	 
	 void addEmployee() {
		    try {
		        String query = "INSERT INTO employee VALUES(DEFAULT, ?, ?, ?, ?, ?, ?, ?)";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);

		        System.out.print("\nEnter Employee Name: ");
		        String ename = scanner.next();
		        System.out.print("Enter Job: ");
		        String job = scanner.next();
		        System.out.print("Enter Manager ID: ");
		        int manager = scanner.nextInt();
		        System.out.print("Enter Hire Date (YYYY-MM-DD): ");
		        String hiredate = scanner.next();
		        System.out.print("Enter Salary: ");
		        double sal = scanner.nextDouble();
		        System.out.print("Enter Commission: ");
		        double comm = scanner.nextDouble();
		        System.out.print("Enter Department Number: ");
		        int deptno = scanner.nextInt();

		        preparedStatement.setString(1, ename);
		        preparedStatement.setString(2, job);
		        preparedStatement.setInt(3, manager);
		        preparedStatement.setString(4, hiredate);
		        preparedStatement.setDouble(5, sal);
		        preparedStatement.setDouble(6, comm);
		        preparedStatement.setInt(7, deptno);
		        preparedStatement.executeUpdate();

		        System.out.println("New Employee Added \n");
		    } catch (Exception e) {
		        System.out.println("Failed to add employee. Error: " + e.getMessage());
		    }
		}
	 
	 void searchByDepartment() {
		 try {
			 
			 String query = "SELECT * FROM employee, department "
				        + "WHERE (employee.deptno = department.deptno) "
				        + "AND (department.dname = ?)";

			 		
		     PreparedStatement preparedStatement = connection.prepareStatement(query);
		     
		     System.out.print("Enter Department to see Employees in it :");
		     String dep = scanner.next();
		     
		     preparedStatement.setString(1, dep);
		     ResultSet resultSet = preparedStatement.executeQuery();

		     System.out.println("\nENAME   JOB    DNAME");
			 while(resultSet.next()) {
					System.out.println(resultSet.getString("ename")+"   " +resultSet.getString("job")+"   " +resultSet.getString("dname"));
			    	
			 }
		     
			 
		 }catch (Exception e) {
		        System.out.println("Failed to show by department. Error: " + e.getMessage());
		 }
	 }
	 
	 void showAllEmployees() {
		    try {
		        String query = "SELECT * FROM employee";

		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(query);

		        System.out.println("\nEMPNO   ENAME   JOB    Sal    Comm");
		        while (resultSet.next()) {
		            System.out.println(resultSet.getInt("empno") + "   " + resultSet.getString("ename") + "   " + resultSet.getString("job") + "   " + resultSet.getString("sal") + "   " + resultSet.getString("comm") );
		        }
		    } catch (Exception e) {
		        System.out.println("Failed to retrieve employees. Error: " + e.getMessage());
		    }
		}
	 
	 
	 void showAllDepartments() {
		    try {
		        String query = "SELECT * FROM department";

		        Statement statement = connection.createStatement();
		        ResultSet resultSet = statement.executeQuery(query);

		        System.out.println("\nDEPTNO   DNAME          LOC");
		        while (resultSet.next()) {
		            System.out.println(resultSet.getInt("deptno") + "   " + resultSet.getString("dname") + "   " + resultSet.getString("loc"));
		        }
		    } catch (Exception e) {
		        System.out.println("Failed to retrieve departments. Error: " + e.getMessage());
		    }
		}

	 void deleteEmployeesBySalary() {
		    try {
		        System.out.print("Enter the minimum salary: ");
		        double minSalary = scanner.nextDouble();

		        String query = "DELETE FROM employee WHERE sal < ?";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setDouble(1, minSalary);
		        int row = preparedStatement.executeUpdate();

		        System.out.println(row + " employees deleted successfully.");
		    } catch (Exception e) {
		        System.out.println("Failed to delete employees. Error: " + e.getMessage());
		    }
		}
	 
	 void increaseCommission() {
		    try {
		        double factor = 20.0; 

		        String query = "UPDATE employee SET comm = comm * (1 + (? / 100))";
		        PreparedStatement preparedStatement = connection.prepareStatement(query);
		        preparedStatement.setDouble(1, factor);
		        int rows = preparedStatement.executeUpdate();

		        System.out.println("\n"+rows + " employees commison increased by "+factor +" successfully.");
		    } catch (Exception e) {
		        System.out.println("Failed to increase employee commissions. Error: " + e.getMessage());
		    }
		}

	 

	
	public static DbConnection getConnection() {
		
		 if (connection != null) {
			 System.out.println("Can Not create new instance");
			 return dbConnection;
         }	else {

    		 dbConnection = new  DbConnection();
    		 return dbConnection;
         }
	}
	
}
