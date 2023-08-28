package com.monocept;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.monocept.dao.StudentDao;
import com.monocept.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	StudentDao studentDAO;
	
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 int choice;
	        do {
	            displayMenu();
	            choice = getUserChoice();
	            processUserChoice(choice);
	        } while (choice != 0);
	}
	
	 private void displayMenu() {
	        System.out.println("Menu:");
	        System.out.println("1. Add Student");
	        System.out.println("2. Get Student by Roll Number");
	        System.out.println("3. Get All Students");
	        System.out.println("4. Update Student");
	        System.out.println("5. Delete Student");
	        System.out.println("0. Exit");
	    }

	    private int getUserChoice() {
	        System.out.print("Enter your choice: ");
	        return scanner.nextInt();
	    }

	    private void processUserChoice(int choice) {
	        switch (choice) {
	            case 1:
	                addStudent();
	                break;
	            case 2:
	                getStudent();
	                break;
	            case 3:
	                getAllStudents();
	                break;
	            case 4:
	                updateStudent();
	                break;
	            case 5:
	                deleteStudent();
	                break;
	            case 0:
	                System.out.println("Exiting the program. Goodbye!");
	                break;
	            default:
	                System.out.println("Invalid choice. Please try again.");
	        }
	        System.out.println();
	    }

	    private void addStudent() {
	       
	        System.out.print("Enter first name: ");
	        String firstname = scanner.next();
	        System.out.print("Enter last name: ");
	        String lastname = scanner.next();
	        System.out.print("Enter email: ");
	        String email = scanner.next();

	        Student student = new Student( firstname, lastname, email);
	        studentDAO.save(student);
	        System.out.println("Student added successfully.");
	    }

	    private void getStudent() {
	        System.out.print("Enter roll number: ");
	        int rollnumber = scanner.nextInt();

	        Student student = studentDAO.getStudent(rollnumber);
	        if (student != null) {
	            System.out.println(student);
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    private void getAllStudents() {
	        System.out.println("All Students:");
	        for (Student student : studentDAO.getAllStudents()) {
	            System.out.println(student);
	        }
	    }

	    private void updateStudent() {
	        System.out.print("Enter roll number: ");
	        int rollnumber = scanner.nextInt();

	        Student existingStudent = studentDAO.getStudent(rollnumber);
	        if (existingStudent != null) {
	            System.out.print("Enter new first name: ");
	            String firstname = scanner.next();
	            System.out.print("Enter new last name: ");
	            String lastname = scanner.next();
	            System.out.print("Enter new email: ");
	            String email = scanner.next();

	            Student updatedStudent = new Student(firstname, lastname, email);
	            studentDAO.updateStudent(updatedStudent, rollnumber);
	            System.out.println("Student updated successfully.");
	        } else {
	            System.out.println("Student not found.");
	        }
	    }

	    private void deleteStudent() {
	        System.out.print("Enter roll number: ");
	        int rollnumber = scanner.nextInt();

	        studentDAO.deleteStudentByRollNumber(rollnumber);
	        System.out.println("Student deleted successfully.");
	    }


}
