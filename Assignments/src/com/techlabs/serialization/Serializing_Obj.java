package com.techlabs.serialization;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializing_Obj {

	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		Employee employees[]= new Employee[5];
		
		employees[0] =new Employee(201,"Abhay",90000);
		employees[1] =new Employee(301,"rahul",90000);
		employees[2] =new Employee(401,"DJ",90000);
		employees[3] =new Employee(501,"sam",90000);
		employees[4] =new Employee(601,"ram",90000);
		
		String fileName = "Obj";
		
		for(int i=0;i<employees.length;i++) {
			fileName ="Obj";
			fileName+=Integer.toString(i+1);
			
			FileOutputStream fos = new FileOutputStream(new File("D:/Monocept/Serialization/"+fileName));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(employees[i]);
		}
		
		FileOutputStream fos = new FileOutputStream(new File("D:/Monocept/Serialization/ObjArray"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(employees);
		
		System.out.println("Serialized Succesfully");
		
	}

}
