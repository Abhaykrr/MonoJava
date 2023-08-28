package com.monocept.model;

import java.math.BigDecimal;

public class Account {
    private String accountNo;
    private String balance;
    private String customerId;
    
    public Account() {}

    public Account(String accountNo, String balance, String customerId) {
        this.accountNo = accountNo;
        this.balance = balance;
        this.customerId = customerId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
