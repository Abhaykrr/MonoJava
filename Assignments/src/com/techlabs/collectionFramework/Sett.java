package com.techlabs.collectionFramework;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sett {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<String> names=new TreeSet<>();
		names.add("Pradeep");
		names.add("Shubham");
		names.add("Abhay");
		names.add("Vismita");
		names.add("Pradeep"); 
		System.out.println(names.size());
		System.out.println(names);
		
		
		Set<String> names1=new LinkedHashSet<>();
		names1.add("Pradeep");
		names1.add("Shubham");
		names1.add("Abhay");
		names1.add("Vismita");
		names1.add("Pradeep"); 
		System.out.println(names1.size());
		System.out.println(names1);
		
		Set<String> names2=new HashSet<>();
		names2.add("Pradeep");
		names2.add("Shubham");
		names2.add("Abhay");
		names2.add("Vismita");
		names2.add("Pradeep"); 
		System.out.println(names2.size());
		System.out.println(names2);
		
		
		Set<Student> students=new HashSet<Student>();

		Student s1=new Student(5,"DDD");

		students.add(new Student(1,"AAA"));

		students.add(new Student(3,"BBB"));

		students.add(new Student(2,"CCC"));

		students.add(new Student(3,"BBB"));

		students.add(s1);

		students.add(s1);

		for(Student student: students)
		System.out.println(student);


	}

}
