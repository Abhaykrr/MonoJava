package com.techlabs.dynamicMethodDispatch;

public class TestMan {

	public static void main(String[] args) {
		Man man = new Boy();
		man.talk();
		man.walk();
		man.eat();
	}

}
