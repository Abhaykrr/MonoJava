package com.techlabs.oops;

public class Employee {
	
	private int eid;
	private String ename;
	private int salary;
	public int getEid() {
		return eid;
	}
	
	Employee(){
		eid=0;
		ename="null";
		salary=0;
	}
	
	Employee(int eid,String ename, int salary){
		this.eid = eid;
		this.ename = ename;
		this.salary = salary;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public void display() {
		System.out.println("Employee id "+eid);
		System.out.println("Employee name "+ename);
		System.out.println("Employee salary " +salary);
	}
	

}
