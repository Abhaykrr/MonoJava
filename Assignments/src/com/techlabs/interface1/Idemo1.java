package com.techlabs.interface1;

public interface Idemo1 {

	default void method() {
		System.out.println("Idemo1");
	}
	
	public static int v() {
		return 0;
	}
}

