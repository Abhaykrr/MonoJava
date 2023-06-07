package com.techlabs.exceptionHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckedException {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		
		try(FileInputStream fis = new FileInputStream(new File("D:/Monocept/TSM/Demo.txt"))) {
			
			System.out.println("File found succesfully");
			
			int ch;
			
			while((ch = fis.read())!=-1) {
				System.out.print((char)ch+" ");
			}
			
		}
		
	
//		catch(FileNotFoundException e) {
//			System.out.println("Enter correct patch");
//		}catch(IOException e) {
//			System.out.println("Format incorrect");
//		}
	}
	
	

}
