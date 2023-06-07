package com.techlabs.collectionFramework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Listt {

	public static void main(String[] args) {
		
		List<String> player = new ArrayList<>();
		player.add("Dhoni");
		player.add("pandya");
		System.out.println(player);
		
		Iterator<String> iterator = player.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		ListIterator<String> it = player.listIterator();
		// helps is traversing back
		
		while(it.hasNext()) {
			System.out.println(it.next() +" playing");
		}
		
		while(it.hasPrevious()) {
			System.out.println(it.previous() +" is out ");
		}
		
		for(String str:player)
			System.out.println(str);
	}

}
