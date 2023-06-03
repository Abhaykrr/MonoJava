package com.techlabs.interface1;

public interface Shape {

	void area();
	
	default void description() {
		System.out.println("Shape Description");
	}
}
