package com.techlabs.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CopyPasteByScanner {
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner scanner = new Scanner(new File("D:/Monocept/file1.txt"));
		FileWriter writer = new FileWriter(new File("D:/Monocept/file2.txt"));
		
		
		 while (scanner.hasNextLine()) {
//              String line = scanner.nextLine();
              writer.write(scanner.nextLine().getBytes());
             }
		
		
		
	}

}
