package com.monocept.model;
public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String password;
    private String accountNo;
    private String balance;
    
    // Constructors
    
    public Customer() {
    	
    }
    
    public Customer(String customerId, String firstName, String lastName, String password, String accountNo, String balance) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accountNo = accountNo;
        this.balance = balance;
    }
    
    // Getters
    
    public String getCustomerId() {
        return customerId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getAccountNo() {
        return accountNo;
    }
    
    public String getBalance() {
        return balance;
    }
    
    // Setters
    
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    
    public void setBalance(String balance) {
        this.balance = balance;
    }
    
    // Other methods and functionalities of the Customer class
}
