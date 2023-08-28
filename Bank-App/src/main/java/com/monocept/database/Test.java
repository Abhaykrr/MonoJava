package com.monocept.database;

public class Test {

	public static void main(String[] args) {
		
		DbConnection db = DbConnection.getConnection();
		db.connect();
		db.checkCustomer("john", "password1");

	}

}
