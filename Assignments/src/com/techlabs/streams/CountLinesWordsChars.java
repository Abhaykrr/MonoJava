package com.techlabs.streams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class CountLinesWordsChars {

	public static void main(String[] args) throws IOException {
		
		
		FileInputStream fileInputStream = new FileInputStream(new File("D:/Monocept/file1.txt"));

	
		int ch;
		
		int charCount =0;
		int wordsCount =0;
		int lineCount =0;
		

		
		
		while((ch = fileInputStream.read()) != -1) {
			
			if((char)ch=='\n') lineCount++;
			
			if((char)ch=='\t' ||(char)ch==' ') charCount++;
			System.out.print((char)ch);
			
			
			if((char)ch==' ') wordsCount++;
			
			
			
		}
		
		
		System.out.println();
		System.out.println("Characters " +charCount);
		System.out.println("Words " +wordsCount);
		System.out.println("Lines " +lineCount);

	}

}
