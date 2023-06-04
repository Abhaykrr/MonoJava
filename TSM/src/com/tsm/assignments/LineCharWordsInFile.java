package com.tsm.assignments;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/*
Enter File Name
Demo.txt
Hi i Am          abhay
GoodMorning

Characters  : 23
Words       : 4
Lines       : 2
*/
public class LineCharWordsInFile {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter File Name");
		String fileName = scanner.next();
	    
		FileInputStream fileInputStream = new FileInputStream(new File("D:/Monocept/tsm/"+fileName));

	
		int ch;
		int charCount  =0;
		int wordsCount =0;
		int lineCount  =1;
		

		char last = ' ';
		System.out.println("File Content :"+"\n");
		while((ch = fileInputStream.read()) != -1) {
			
			System.out.print((char)ch);
			
			if((char)ch=='\n') lineCount++;
			
			if((char)ch!=' ') charCount++;
			
			if((char)ch==' ' && last !=' ') wordsCount++;
			
			last = (char)ch;
			
		}
		
		if(last !=' ') wordsCount++;
		
		
		System.out.println("\n");
		System.out.println("Characters  : " +charCount);
		System.out.println("Words       : " +wordsCount);
		System.out.println("Lines       : " +lineCount);
		
		fileInputStream.close();
		scanner.close();

	}

}

