package com.tsm.StreamsApi;

import java.io.*;
import java.util.*;

public class Movie implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int movieId;
    private String movieName;
    private int movieYear;
    private String movieGenre;

    public Movie(int movieId, String movieName, int movieYear, String movieGenre) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieYear = movieYear;
        this.movieGenre = movieGenre;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getMovieYear() {
        return movieYear;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    @Override
    public String toString() {
        return "Movie ID: " + movieId + ", Name: " + movieName + ", Year: " + movieYear + ", Genre: " + movieGenre;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieManager movieManager;
        File movieFile = new File("D:/Monocept/TSM/src/com/tsm/MovieApp/MovieData.txt");

        try {
            if (movieFile.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(movieFile));
                movieManager = (MovieManager) ois.readObject();
                ois.close();
            } else {
                movieManager = new MovieManager();
            }

            int choice = -1;

            while (choice != 0) {
                System.out.println("\nEnter 1 to show movies");
                System.out.println("Enter 2 to add a movie");
                System.out.println("Enter 3 to delete a movie by ID");
                System.out.println("Enter 4 to delete all movies");
                System.out.println("Enter 5 to save progress");
                System.out.println("Enter 0 to exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        movieManager.showMovies();
                        break;
                    case 2:
                        System.out.print("\nEnter movie ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter movie name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter movie year: ");
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter movie genre: ");
                        String genre = scanner.nextLine();
                        movieManager.addMovie(new Movie(id, name, year, genre));
                        break;
                    case 3:
                        System.out.print("\nEnter the movie ID to delete: ");
                        int movieId = scanner.nextInt();
                        movieManager.deleteMovieById(movieId);
                        break;
                    case 4:
                        movieManager.deleteAllMovies();
                        break;
                    case 5:
                        movieManager.saveProgress(movieFile);
                        break;
                    case 0:
                        System.out.println("\nExiting the program...");
                        break;
                    default:
                        System.out.println("\nInvalid choice! Please try again.");
                        break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class MovieManager implements Serializable {
    private Map<Integer, Movie> movies;

    public MovieManager() {
        this.movies = new HashMap<>();
    }

    public void showMovies() {
        if (movies.isEmpty()) {
            System.out.println("\nNo movies available.");
        } else {
            System.out.println("\nMovies List:");
            movies.values().forEach(System.out::println);
        }
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getMovieId(), movie);
        System.out.println("\nMovie added successfully.");
    }

    public void deleteMovieById(int id) {
        Movie removedMovie = movies.remove(id);
        if (removedMovie != null) {
            System.out.println("\nMovie with ID " + id + " deleted successfully.");
        } else {
            System.out.println("\nMovie with ID " + id + " does not exist.");
        }
    }

    public void deleteAllMovies() {
        movies.clear();
        System.out.println("\nAll movies deleted successfully.");
    }

    public void saveProgress(File movieFile) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(movieFile));
            oos.writeObject(this);
            oos.close();
            System.out.println("\nProgress saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

