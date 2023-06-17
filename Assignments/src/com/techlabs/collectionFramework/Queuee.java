package com.techlabs.collectionFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Queuee {

	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<>(Arrays.asList(1,2,3));
		
		
		q.add(4);
		
		System.out.println(q.peek());
		q.poll();
		
		System.out.println(q);
	}

}
