package com.techlabs.inheritance;

public class CarCompany {

	public static void main(String[] args) {
		
		Car cars[]= new Car[5];
		
		cars[0] = new Car("BMW",15,30);
		cars[1] = new Car("Audi",25,20);
		cars[2] = new Car("Jaguar",10,33);
		cars[3] = new Car("Jeep",5,23);
		cars[4] = new Car("Tesla",105,40);
		
		for(int i=0;i<cars.length;i++)
			System.out.println(cars[i]);
		
	}
	

}

class Vehicle{
	
	String company;
	
	Vehicle(String company){
		this.company = company;
	}
}

class FourWheeler extends Vehicle{
	
	int mileage;

	FourWheeler(String company, int mileage) {
		super(company);
		this.mileage = mileage;
	}
	
}

class Car extends FourWheeler{
	
	int price;

	Car(String company, int mileage,int price) {
		super(company, mileage);
		this.price = price;
	}
	

	
	public String toString(){
		return "Car Company : " +this.company +"     Car Mileage : " +this.mileage +" Car Price : " +this.price +" Lacks";
		
	}
	
}
