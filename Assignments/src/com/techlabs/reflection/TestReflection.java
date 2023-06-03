package com.techlabs.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestReflection {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Class reference = Class.forName("java.lang.String");
		
		
		
		System.out.println(reference.getClass());
		System.out.println(reference.getName());
		System.out.println(reference.getSimpleName());
		
		Constructor constructors[] = reference.getConstructors();
		
		for(Constructor constructor :constructors)
			System.out.println(constructor);
		
		Method methods[]= reference.getMethods();
		
		for(Method method :methods)
			System.out.println(method.getName());
		
		
	}

}
