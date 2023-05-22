package com.techlabs.streams;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyPasteByScanner {
	
	public static void main(String[] args) throws IOException {
		
		
		Scanner f = new Scanner(new File("D:/Monocept/file1.txt"));
	    FileOutputStream fos = new FileOutputStream("D:/Monocept/file2.txt");
		
		while(f.hasNext()) {
			System.out.println(f.nextLine());
			
		}
		
	}

}
