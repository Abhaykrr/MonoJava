package com.techlabs.executableThread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ListOfThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService service=Executors.newFixedThreadPool(2);
		List<Demo> threads=new ArrayList<>();
		threads.add(new Demo());
		threads.add(new Demo());
		threads.add(new Demo());
		threads.add(new Demo());
		threads.add(new Demo());
		
		service.invokeAny(threads);
		
		List<Future<String>> futures=  service.invokeAll(threads);
		for(Future<String> future:futures)
		System.out.println(future.get());
		
		service.shutdown();
		
//		for(Demo thread : threads)
//
//		{
//		Future future = service.submit(thread);
//		System.out.println(future.get());
//
//		}
	}

}
