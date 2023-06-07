package com.techlabs.comparatorClass;

import java.util.*;

public class EmployeeTest {

	public static void main(String[] args) {
		
		Set<Employee> employees = new TreeSet<>(new EmployeeById() );
		employees.add(new Employee(1,"Abhay",2000));
		employees.add(new Employee(4,"Sk",4000));
		employees.add(new Employee(3,"Pk",3000));
		employees.add(new Employee(2,"KK",1000));
		employees.add(new Employee(6,"Dk",5000));
		
		
		
		System.out.println(employees);
		

		

	}

}
