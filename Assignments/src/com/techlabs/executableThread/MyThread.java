package com.techlabs.executableThread;

public class MyThread implements Runnable {
	Thread t;
	MyThread(){
		t= new Thread(this);
		System.out.println("Thread Created");
		t.start();
	}

	@Override
	public void run() {
		
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName()+" " +i);
		}
	}

	
}
