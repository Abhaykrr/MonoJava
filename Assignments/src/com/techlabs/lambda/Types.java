package com.techlabs.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Types {
																																																																																																																																																																																																																																																																																																																																																																																																																																																													
	
	public static void main(String[] args) {
		Consumer<String> consumer =(string)->System.out.println(string);
		consumer.accept("ConsumeP Functional Interface");
		
		BiConsumer<Integer,Integer> biConsumer=(a,b)->System.out.println(a+b);
		biConsumer.accept(10, 26);
		
		Supplier<String> supplier=  ()-> "Java World";
		System.out.println("Hello "+supplier.get());
		
		Predicate<Integer> evenPredicate=(number)-> number%2==0;
		System.out.println(evenPredicate.test(5));
		
		BiPredicate<Integer,Integer> checkMax = (num1,num2) ->num1>num2;
		
		if(checkMax.test(6, 5)) {
			System.out.println("greater");
		}else {
			System.out.println("smaller");
		}
//	___________________________________________________________________________	
		   Function<Integer,Integer> factFunction=(number)->{
			int fact=1;
				for(int i=1;i<=number;i++)
				fact=fact*i;
			return fact;
			
			};
			
			System.out.println(factFunction.apply(5));
			
			 Function<Integer,Integer> squareFunction=(number)->{return number*number;};
			 System.out.println();
//___________________________________________________________________________________-			 
			 
			    BinaryOperator<Integer> add = (a, b) ->(a + b);

		        int result = add.apply(5, 3);
		        System.out.println(result); 
			 
//__________________________________________________________________________
		        UnaryOperator<Integer> square = x -> x * x;

		        int result1 = square.apply(5);
		        System.out.println(result1);
		        
		        System.out.println(add.andThen(square).apply(2, 3));
			 
			}
	
}
