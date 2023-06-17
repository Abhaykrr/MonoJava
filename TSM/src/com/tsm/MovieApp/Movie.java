package com.tsm.MovieApp;

import java.io.Serializable;

public class Movie implements Serializable {
	
	private int movieId;
	private String movieName;
	private int movieYear;
	private String movieGenre;
	
	public Movie(){};
	// Sample I/O is in MovieTest.java
	public Movie(int movieId, String movieName, int movieYear, String movieGenre) {
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieYear = movieYear;
		this.movieGenre = movieGenre;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getMovieYear() {
		return movieYear;
	}

	public void setMovieYear(int movieYear) {
		this.movieYear = movieYear;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	@Override
	public String toString() {
		return "Movie [(" + movieName + "," + movieYear + ","
				+ movieGenre + ")]";
	}
	
	
	
	

}
