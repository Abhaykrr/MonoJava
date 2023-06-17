package com.tsm.MovieApp;

import java.io.IOException;

public class MovieTest {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		MovieController movieController = new MovieController();
		movieController.start();
		

	}

} // Sample I/O is in MovieTest.java

/*
 
Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 1

End of file reached. No Movies to show

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 2

 ENTER MOVIE DETAILS
Movie Id : 1
Movie Year : 2008
Movie Genere : adventure
Movie Name : avatar

Added successfully

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 2

 ENTER MOVIE DETAILS
Movie Id : 2
Movie Year : 2013
Movie Genere : comdey
Movie Name : golmal

Added successfully

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 1

1=Movie [(avatar,2008,adventure)]
2=Movie [(golmal,2013,comdey)]

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 3

 ENTER MOVIE ID TO DELETE
1

Movie Deleted Successfully

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 1

2=Movie [(golmal,2013,comdey)]

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 4

All Movies Deleted

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 1

No Movies in DataBase

Enter 1 TO SHOW MOVIES
Enter 2 TO ADD  MOVIES
Enter 3 TO DELETE BY ID MOVIES
Enter 4 TO DELETE ALL MOVIES
Enter 0 TO EXIT
Enter your choice : 0
*/

