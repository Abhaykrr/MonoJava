package com.techlabs.threads;

public class Test {
	
	{
		Mythread m = new Mythread("demo");
		m.start();
	}

	public static void main(String[] args) {
		Mythread m1 = new Mythread("M one");
		Mythread m2 = new Mythread("M two");
		Mythread m3 = new Mythread("M three");
		
		
		
		for(int i=1;i<=5;i++) {
			System.out.println(Thread.currentThread().getName() +i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			m1.join();
			m2.join();
			m3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
