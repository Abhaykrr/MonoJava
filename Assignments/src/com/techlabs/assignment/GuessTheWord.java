package com.techlabs.assignment;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

/*Rule of the game
	 A word will be generated
	 you have (word length +2(bonus)) chances
	 At Each Guess you can have two ways
	 1.> you can Guess any char like {"a","b",.....,"z"}
	 2.> For saving your chances you can guess the entire word of the same length
	
	Sample I/O at bottom
	*/

public class GuessTheWord {
	
	 public static String[] words = {"happy","monocept","object","bottle","mosquito"};
	 static Scanner scanner = new Scanner(System.in);
	 static int tries = 0;

	public static void main(String[] args) {
		
	  String randomWord = randomWord();
	  System.out.println(+randomWord.length() +" Letter Word Generated (" +randomWord +")");
	  System.out.println("You have "+(randomWord.length()+2)+" Guesses \n");
	  startGame(randomWord);
	}
	
	public static void startGame(String randomWord) {
		
		char ans[] = new char[randomWord.length()];
		String current = "";
		Arrays.fill(ans, '_');
		generateStatus(ans);
		
		while(tries<=randomWord.length()+2) {
			System.out.print("Guess " +(tries+1)+": ");
			current = scanner.next();
			
			if(current.length()==randomWord.length()) {
				matchString(current,ans,randomWord);
				tries++;
				generateStatus(ans);
			}
			else if(current.length()==1) {
				matchChar(current,ans,randomWord);
				tries++;
				generateStatus(ans);
			}
			else
				System.out.println("Enter a valid length");
		}
		System.out.println("You Loose");
		
	}

	public static void matchChar(String current, char[] ans, String randomWord) {
		
		for(int i=0;i<ans.length;i++) {
			if(randomWord.charAt(i)==current.charAt(0) && ans[i]=='_') {
				ans[i]=current.charAt(0);
				break;
			}
		}
		
	}

	public static void matchString(String current, char[] ans, String randomWord) {
		
		for(int i=0;i<ans.length;i++) {
			if(randomWord.charAt(i)==current.charAt(i)) {
				ans[i]=current.charAt(i);
			}
		}
		
	}

	public static void generateStatus(char[] ans) {
		int count = 0;
		for(char curr: ans) {
			System.out.print(curr+"  ");
			if(curr!='_') count++;
			if(count == ans.length) {
				System.out.println("You win in " +tries+" guesses");
				System.exit(0);
			}
		}
	}

	public static String randomWord() {
		Random random = new Random();
		int randomNumber = random.nextInt(words.length);
		return words[randomNumber];
	}

}

/*
6 Letter Word Generated (bottle)
You have 8 Guesses 

_  _  _  _  _  _  Guess 1: b
b  _  _  _  _  _  Guess 2: turtle
b  _  _  t  l  e  Guess 3: o
b  o  _  t  l  e  Guess 4: o
b  o  _  t  l  e  Guess 5: t
b  o  t  t  l  e  You win in 5 guesses

 */
