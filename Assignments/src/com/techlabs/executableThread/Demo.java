package com.techlabs.executableThread;

import java.util.concurrent.Callable;

public class Demo implements Callable<String>{
@Override
	public String call() throws Exception {
	Thread.sleep(500);
	return "Executor Service Demo";
	}
}
