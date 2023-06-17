package com.tsm.MovieApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class MovieController {
	
	static Scanner scanner = new Scanner(System.in);
	
	public void start() throws IOException, ClassNotFoundException {
		
	MovieManager movieManager = new MovieManager();

	// Sample I/O is in MovieTest.java
	
	while(true) {
		int choice =  displayMenu();
		
		switch (choice){
		
		case 1:{   // LOAD MOVIES
			
			movieManager.loadMovies(); 
			break;
		}
		case 2:{   // ADD MOVIE
			
			Movie newMovie =  getData();
			movieManager.addMovies(newMovie);
			
			break;
		}case 3:{  // DELETE MOVIE BY ID 
			
			System.out.println("\n ENTER MOVIE ID TO DELETE");
			int id = scanner.nextInt();
			movieManager.deleteMovieById(id);
			break;
		}
		case 4:{   // DELETE ALL MOVIES
			
			movieManager.deleteAllMovies();
			break;
		}
		case 5:{   // SAVE PROGRESS
			
			movieManager.saveMovie();
			break;
		}
		case 0:{
			System.exit(0);
			break;
		}
		default:{
			System.out.println("Enter Valid Choice");
		}
			
		}
	}
	}



	private static Movie getData() {
		System.out.println("\n ENTER MOVIE DETAILS");
		System.out.print("Movie Id : ");
		int id = scanner.nextInt();
		System.out.print("Movie Year : ");
		int year = scanner.nextInt();
		System.out.print("Movie Genere : ");
		String genere =  scanner.next();
		System.out.print("Movie Name : ");
		String name = scanner.next();
		
		
		return new Movie(id,name,year,genere);
	}

	private static int displayMenu() {
		
		System.out.println("\nEnter 1 TO SHOW MOVIES");
		System.out.println("Enter 2 TO ADD  MOVIES");
		System.out.println("Enter 3 TO DELETE BY ID MOVIES");
		System.out.println("Enter 4 TO DELETE ALL MOVIES");
		System.out.println("Enter 0 TO EXIT");
		System.out.print("Enter your choice : ");
		
		return scanner.nextInt();
		
		
	}
	


}
