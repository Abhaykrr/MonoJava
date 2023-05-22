package com.techlabs.streams;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFromOneFileToAnother {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fileInputStream = new FileInputStream(new File("D:/Monocept/file1.txt"));
	    FileOutputStream fos = new FileOutputStream("D:/Monocept/file2.txt");
	
		int ch;
		
		while((ch = fileInputStream.read()) != -1) {
			
			System.out.print((char)ch);
			 fos.write(ch);
			
		}
		
		fileInputStream.close();
		fos.close();
		
		
		
	}
	

}
