package com.techlabs.collectionFramework;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueue_DeQUEUE {

	public static void main(String[] args) {
		
		Queue queue = new PriorityQueue<>();
		PriorityQueue<Integer> pqueue = new PriorityQueue<>(Comparator.reverseOrder());
		
		pqueue.add(10); // throws exception when size exceeds
		pqueue.offer(30); // not throws exception when size exceed
		pqueue.add(50);
		pqueue.add(5);
		pqueue.add(15);
		System.out.println(pqueue.peek());
		System.out.println(pqueue.poll());
		System.out.println(pqueue.contains(15));
		pqueue.remove(30);
		
		pqueue.clear();
		
//		System.out.println(pqueue.element());  // throws exception
		System.out.println(pqueue.peek());
		
		
		System.out.println(pqueue);
		
	}

}
