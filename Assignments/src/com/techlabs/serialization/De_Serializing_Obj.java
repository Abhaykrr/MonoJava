package com.techlabs.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class De_Serializing_Obj {

	public static void main(String[] args) throws IOException ,FileNotFoundException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream(new File("D:/Monocept/Serialization/ObjArray"));
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Employee emp[] = (Employee[]) ois.readObject();
		
		for(int i=0;i<emp.length;i++)
			System.out.println(emp[i]);
	}
	
	static void display() {
		try {
			String fileName ;
			for(int i=0;i<5;i++) {
				fileName ="Obj";
				fileName+=Integer.toString(i+1);
				
				FileInputStream fis = new FileInputStream(new File("D:/Monocept/Serialization/"+fileName));
				ObjectInputStream ois = new ObjectInputStream(fis);
				
				Employee emp = (Employee) ois.readObject();
				System.out.println(emp);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
