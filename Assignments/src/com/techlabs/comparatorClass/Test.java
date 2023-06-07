package com.techlabs.comparatorClass;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {

	public static void main(String[] args) {
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(3,"Ak"));
		students.add(new Student(2,"kk"));
		students.add(new Student(4,"Anil"));
		students.add(new Student(1,"dk"));
		
		Collections.sort(students,new CompareByRoll());
		System.out.println(students);
		
	}

}
