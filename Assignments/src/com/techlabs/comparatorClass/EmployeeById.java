package com.techlabs.comparatorClass;

import java.util.Comparator;

public class EmployeeById implements Comparator<Employee> {

	@Override
	public int compare(Employee s1, Employee s2) {
		
		return s1.getEmployeeId()-s2.getEmployeeId();
	}

}
