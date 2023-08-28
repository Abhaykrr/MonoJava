package com.monocept.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Util {
	
	public static Date getTodaysDate() {
		 java.util.Date today = new java.util.Date();
	        return new Date(today.getTime());
	}
	
	public static Date getDateAfterMonths(int noOfMonths) {
		   LocalDate today = LocalDate.now();
	        LocalDate newDate = today.plusMonths(noOfMonths);
	        return Date.valueOf(newDate);
	}

}
