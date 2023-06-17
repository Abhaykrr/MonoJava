package com.techlabs.lambda;

import java.util.function.Consumer;

public class Factorial {

	public static void main(String[] args) {
		Consumer<Integer> consumer =(a)->{
			int ans=1;
			for(int i=1;i<=a;i++)
				ans*=i;
			
			System.out.println(ans);
		};
		consumer.accept(5);
	}

}
