package com.techlabs.collectionFramework;

import java.util.ArrayList;
import java.util.List;

public class StudentTest {

	public static void main(String[] args)
	{
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(1,"Ak"));
		students.add(new Student(2,"kk"));
		students.add(new Student(3,"Anil"));
		
		System.out.println("Number of students added so far:"+students.size());
		
		for(Student student: students)
			System.out.println(student);

		System.out.println(students);
		System.out.println("Student at 2 index:"+students.get(2));
	}

}
