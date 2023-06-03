package com.tsm.customerAssc;


public class Customer {
	
	private int customerId;
    private String name;
    private String email;
    private String password;
    
    
     Customer(){
    	 
     }
    
	 Customer(int customerId, String name, String email, String password) {
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public int getCustid() {
		return customerId;
	}
	public void setCustid(int custid) {
		this.customerId = custid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
    public void displayCustomerInfo() {
    	System.out.println("---------------------------------");
        System.out.println("Customer ID     : " + customerId);
        System.out.println("Name            : " + name);
        System.out.println("Email           : " + email);
        System.out.println("Password        : " + password);
        System.out.println("---------------------------------");
    }

}
