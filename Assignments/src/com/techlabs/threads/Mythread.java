package com.techlabs.threads;

public class Mythread extends Thread{
	
	
	public Mythread(String name) {
		super(name);
		start();
	}


	public void run() {
		System.out.println("Thread Started");
		
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName() +i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
