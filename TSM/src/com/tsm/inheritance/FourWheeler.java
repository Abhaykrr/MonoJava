package com.tsm.inheritance;

public class FourWheeler extends Vehicle{
	
	private double mileage;

	public FourWheeler(String companyName,Double mileage) {
		super(companyName);
		this.mileage = mileage;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	

}
