package com.techlabs.collectionFramework;

import java.util.*;


public class DoublyQueue {

	public static void main(String[] args) {
		
		Deque<Integer> dq1 = new LinkedList<>();
		Deque<Integer> dq = new ArrayDeque<>(Arrays.asList(1,2,3));
		
		dq.add(5);
		
		dq.addFirst(0);
		dq.addLast(6);
		
		System.out.println(dq);
		
		dq.removeFirst();
		dq.removeLast();
		
		System.out.println(dq);
		
		
		
	}

}
