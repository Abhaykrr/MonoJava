package com.techlabs.threads;

public class TestRunnable {

	public static void main(String[] args) throws InterruptedException {
	
		MyTreadRunnable mythread = new MyTreadRunnable();
		MyTreadRunnable mythread2 = new MyTreadRunnable();
		
		Thread thread1 = new Thread(mythread);
		Thread thread2 = new Thread(mythread);
		thread1.setName("thread t1");
		thread2.setName("thread t2");
		thread2.start();
		thread1.start();
		
		thread1.join();
		
		System.out.println(Thread.currentThread().getName());
		
	}

}
