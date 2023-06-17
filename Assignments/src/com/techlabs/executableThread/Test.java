package com.techlabs.executableThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

	public static void main(String[] args) {
		ExecutorService service=Executors.newCachedThreadPool();
		MyThread myThread=new MyThread();
		Demo demo = new Demo();
		myThread=new MyThread();
		service.execute(myThread);
		

		Future future=service.submit(myThread);
		System.out.println("Task Done?:"+future.isDone());
		
		
		try {
			future.get();

			} catch (InterruptedException e) {
			// TODO Auto—generated catch block
			e.printStackTrace();

			} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			}

			System.out.println("Task Done?:"+future.isDone());
	}

}
