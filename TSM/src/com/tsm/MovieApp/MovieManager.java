package com.tsm.MovieApp;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class MovieManager {
	
	private Map<Integer,Movie> movies;
	private static String path = "D:/Monocept/TSM/src/com/tsm/MovieApp/MovieData.txt";
	
	// Sample I/O is in MovieTest.java
	
	public MovieManager() throws IOException {
		this.movies =  new HashMap<>();
	}
	
	public void loadMovies() throws ClassNotFoundException, IOException  {
	
		FileInputStream fis = new FileInputStream(new File(path));
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		 try {
             movies = (Map<Integer, Movie>) ois.readObject();
             System.out.println();
             movies.entrySet().stream().forEach((entry)->System.out.println(entry));
             if(movies.size()==0) System.out.println("No Movies in DataBase");
             
             
         } catch (EOFException  e) {
             System.out.println("\nEnd of file reached. No Movies to show");
         }
		
		fis.close();
		ois.close();
		
	}
	
	public void saveMovie() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream(new File(path));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			oos.writeObject(movies);
			
			fos.close();
			oos.close();
		
	}
	
	public void deleteAllMovies() throws IOException, ClassNotFoundException {
		
		FileOutputStream fos = new FileOutputStream(new File(path));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
	
			 movies.clear();
			 oos.writeObject(movies);
			System.out.println("\nAll Movies Deleted");
		
		fos.close();
		oos.close();
		
	}
	
	public void deleteMovieById(int id) throws ClassNotFoundException, IOException {
	
		FileOutputStream fos = new FileOutputStream(new File(path));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
			
			 if(movies.containsKey(id)) {
				 movies.remove(id);
				 oos.writeObject(movies); 
				 System.out.println("\nMovie Deleted Successfully");
			 }else {
				 System.out.println("\nMovie Not Found");
			 }
			
		
		fos.close();
		oos.close();
	}
	


	public void addMovies(Movie movie) throws IOException, ClassNotFoundException {

		FileOutputStream fos = new FileOutputStream(new File(path));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
	   
		movies.put(movie.getMovieId(), movie);
		oos.writeObject(movies);
		System.out.println("\nAdded successfully");
		
		fos.close();
		oos.close();
	}
}
