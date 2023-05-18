package com.techlabs.controlstructures;

import java.util.Scanner;

public class Switchh {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		    int n=7;    
		    String month=""; 
		    switch(n){    
		    case 1: month="1 - January";  
		    break;    
		    case 2: month="2 - February";  
		    break;    
		    case 3: month="3 - March";  
		    break;    
		    case 4: month="4 - April";  
		    break;    
		    case 5: month="5 - May";  
		    break;    
		    case 6: month="6 - June";  
		    break;    
		    case 7: month="7 - July";  
		    break;    
		    case 8: month="8 - August";  
		    break;    
		    case 9: month="9 - September";  
		    break;    
		    case 10: month="10 - October";  
		    break;    
		    case 11: month="11 - November";  
		    break;    
		    case 12: month="12 - December";  
		    break;    
		    default:System.out.println("Invalid Month");    
		    }   
		    System.out.println(month);
		    
		    
		    while(true) {
		    	
		    	System.out.println("Select 1 to Restart");
		    	System.out.println("Select 2 to Update");
		    	System.out.println("Select 3 to Shutdown");
		    	
		    	int choice = scanner.nextInt();
		    	
		    	 switch(choice){    
				    case 1:
				    	System.out.println("System Restarted");  
			            break;  
				    case 2: 
				    	System.out.println("System Updated");  
		                break;  
				    case 3: 
				    	System.out.println("Shutting Down");
				    	System.exit(0);
		                break;   
		            default:
		            	System.out.println("Provide Valid Input");
		    	 }
		    	 System.out.println();
		    	
		    }
		

	}

}
