package com.tsm.emailValidation;


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
    
    public String toString() {
    	
    	String display = "";
    	display+="---------------------------------\n";
    	display+="Customer ID     : " + customerId+"\n";
    	display+="Name            : " + name+"\n";
    	display+="Email           : " + email+"\n";
    	display+="Password        : " + password+"\n";
    	display+="---------------------------------"+"\n";
    	
    	return display;
    }

}
