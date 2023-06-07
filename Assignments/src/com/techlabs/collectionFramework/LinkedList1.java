package com.techlabs.collectionFramework;


import java.util.*;
public class LinkedList1 {

	public static void main(String[] args) {
		LinkedList<String> players=new LinkedList<>();
		
		players.add("Rohit");
		players.add("Virat");
		players.add("Ajinkya");
		players.addFirst("Shubhmman");
		System.out.println(players);
		
		for(String player:players)
		{

		System.out.println(player+" is playing");
		}
		players.addLast("Ishan");
		System.out.println(players);
	}

}
