package com.techlabs.enums;

public class Patient {

	private String name;
	private BpLevel bpLevel;
	private String medicine;
	
	 Patient(){
		 
	 }
	
	Patient(String name, BpLevel bpLevel) {
		this.name = name;
		this.bpLevel = bpLevel;
		this.medicine="Not Prescribed";
		
		prescribe();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BpLevel getBpLevel() {
		return bpLevel;
	}

	public void setBpLevel(BpLevel bpLevel) {
		this.bpLevel = bpLevel;
	}
	 
	public String toString() {
		return "Name : "+name +"\n"+"BpLevel : " +bpLevel +"\n" +"Medicine "+medicine ;
	}
	
	public void prescribe() {
		if(bpLevel==BpLevel.high) {
			this.medicine = "Dolo650";
		}else if(bpLevel==BpLevel.low) {
			this.medicine = "Dolo350";
		}else {
			this.medicine = "Dolo250";
		}
	}
	
	
	
}
