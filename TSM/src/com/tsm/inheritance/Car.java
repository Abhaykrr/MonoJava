package com.tsm.inheritance;

public class Car extends FourWheeler {
	
	private double price;

	public Car(String companyName, Double mileage, Double price) {
		super(companyName, mileage);
		this.price = price;
	}
	
	public String toString() {
		
		String display = "";
		
		display +="CompanyName : " +getCompanyName();
		display +=" Mileage  : " +getMileage();
		display +=" Price   :" +this.price;
		
		return display;
	}

}
