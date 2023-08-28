package com.monocept.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.monocept.model.*;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  


public class DbConnection {
	
	private static DbConnection dbConnection;
	private static Connection connection ;
	
	private static Scanner scanner = new Scanner(System.in);
	private static String url = "jdbc:mysql://localhost:3306/";
	private static String username = "root";
    private static String password = "root";
    private static String DB_NAME = "BANK";
	
	private DbConnection() {}
	
	public void connect() {
		
	       
	        try  {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	        	connection =  DriverManager.getConnection(url+DB_NAME, username, password);
	            System.out.println("Bank DB Connected Successfully");
	      
	        	
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
     	public Customer checkCustomer(String firstname, String password) { 
     		
     		 Customer customer = new Customer();
    	
    	 
    	 try {
    		 String query = "SELECT * FROM customer WHERE firstname = ? AND password_ = ?";
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1, firstname);
             statement.setString(2, password);
             ResultSet resultSet = statement.executeQuery();
             
             if (resultSet.next()) {
            	 
            	
            	 
            	 customer.setCustomerId( String.valueOf(resultSet.getInt("customerid")));
            	 customer.setFirstName( resultSet.getString("firstname"));
            	 customer.setLastName( resultSet.getString("lastname"));  
            	 customer.setPassword(resultSet.getString("password_"));
            	 
                 System.out.println("Customer Authentication successful");
             } else {
                 System.out.println("Customer Authentication failed");
             }
             
             resultSet.close();
             statement.close();
    	 }catch(Exception e) {
    		 System.out.print("Exception While checking cutomer authentication  :");
    		 e.printStackTrace();
    		 System.out.println();
    	 }
    	 
    	 return customer;
     }
     
     public String[] checkAdmin(String firstname, String password) { 
    		
    	 String userData[] = new String[3];
    	 userData[0]="false";
    	 
    	 try {
    		 String query = "SELECT * FROM admin_ WHERE firstname = ? AND password_ = ?";
             PreparedStatement statement = connection.prepareStatement(query);
             statement.setString(1, firstname);
             statement.setString(2, password);
             ResultSet resultSet = statement.executeQuery();
             
             if (resultSet.next()) {
            	 
            	 userData[0] = String.valueOf(resultSet.getInt("adminid"));
            	 userData[1] = resultSet.getString("firstname");
            	 userData[2] = resultSet.getString("password_");  
            	 
                 System.out.println("Admin Authentication successful");
             } else {
                 System.out.println("Admin Authentication failed");
             }
             
             resultSet.close();
             statement.close();
    	 }catch(Exception e) {
    		 System.out.print("Exception while checking admin authentication :");
    		 e.printStackTrace();
    		 System.out.println();
    	 }
    	 
    	 return userData;
     }

     public List<Customer> getAllCustomers() {
    	 List<Customer> customers = new ArrayList<>();
    	 
    	 String query = "SELECT * FROM customer";
    	 
    	 try {
			 	PreparedStatement statement = connection.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();
	            
	           
	            
	            while (resultSet.next()) {
	            	int customerid = resultSet.getInt("customerid");
	                String firstName = resultSet.getString("firstname");
	                String lastName = resultSet.getString("lastname");
	               
	                Customer curr = new Customer();
	                curr.setCustomerId(Integer.toString(customerid));
	                curr.setFirstName(firstName);
	                curr.setLastName(lastName);
	                customers.add(curr);
	                
	              
	            }
		 }catch(Exception e) {
			 System.out.println("Exception in getAllCustomers :"+e);
		 }
		 
    	 
    	 return customers;
     }
	
     public List<Customer> getAllCustomersWithAccount() {
    	 
    	 List<Customer> customers = new ArrayList<>();
    	 String query = "SELECT c.firstname,c.customerid, c.lastname, a.accountno, a.balance " +
                 "FROM account a " +
                 "INNER JOIN customer c ON c.customerid = a.customerid";

		 try {
			 	PreparedStatement statement = connection.prepareStatement(query);
	            ResultSet resultSet = statement.executeQuery();
	            
	           
	            
	            while (resultSet.next()) {
	            	int customerid = resultSet.getInt("customerid");
	                String firstName = resultSet.getString("firstname");
	                String lastName = resultSet.getString("lastname");
	                int accountNo = resultSet.getInt("accountno");
	                double balance = resultSet.getDouble("balance");

	             Customer curr = new Customer();
	             curr.setCustomerId(Integer.toString(customerid));
	             curr.setFirstName(firstName);
	             curr.setLastName(lastName);
	             curr.setPassword(password);
	             curr.setAccountNo(Integer.toString(accountNo));
	             curr.setBalance(Double.toString(balance));
	             
	             customers.add(curr);
	            
	              
	            }
		 }catch(Exception e) {
			 System.out.println("Exception in getAllCustomersWithAccount :"+e);
		 }
		 
		 return customers;
     }
     
     public boolean addNewCustomer(String firstname,String lastname, String password) {
    	 
    	 boolean status = false;
    	 try {
    		 
    		 String sql = "INSERT INTO customer (firstname, lastname, password_) VALUES (?, ?, ?)";
    	     PreparedStatement statement = connection.prepareStatement(sql);

    	        statement.setString(1, firstname);
    	        statement.setString(2, lastname);
    	        statement.setString(3, password);

    	        statement.executeUpdate();
    	        statement.close();
    	        
    	        status = true;
    	        System.out.println("New customer added successfully.");
    	    } catch (SQLException e) {
    	        System.out.println("Error adding new customer: " + e.getMessage());
    	    }
    	 
    	 return status;
     }
     
     
     public String createAccount(String customerid,String balance) {
    	 String generated = "null";
    	 try {
             String query = "INSERT INTO account (customerid, balance) VALUES (?, ?)";
             PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
             statement.setInt(1, Integer.parseInt(customerid));
             statement.setDouble(2, Double.parseDouble(balance));
             
             int rowsAffected = statement.executeUpdate();
             if (rowsAffected == 1) {
                 ResultSet generatedKeys = statement.getGeneratedKeys();
                 if (generatedKeys.next()) {
                     int accountno = generatedKeys.getInt(1);
                     
                     generated = Integer.toString(accountno);
                     System.out.println("Account created successfully. Account No: " + accountno);
                 }
                 generatedKeys.close();
             } else {
                 System.out.println("Failed to create the account.");
             }
             
             statement.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    	 
    	 return generated;
     }
     
     
     //--------------------Customer----------------------------------------------
     
     public List<Account> getParticualarCustomerAccountDetails(String customerid) {
    	 List<Account> accounts = new ArrayList<>();
    	 
          try {
              String query = "SELECT * FROM account WHERE customerid = ?";
              PreparedStatement statement  = connection.prepareStatement(query);
              statement.setString(1, customerid);

              
              ResultSet rs =  statement.executeQuery();

              while (rs.next()) {
                  int accountNo = rs.getInt("accountno");
                  double balance = rs.getDouble("balance");
                 
                  Account curr = new Account();
                  curr.setCustomerId(customerid);
                  curr.setAccountNo(String.valueOf(accountNo));
                  curr.setBalance(String.valueOf(balance));
                  
                  accounts.add(curr);

//                  List<String> curr = new ArrayList<>();
//                  curr.add(String.valueOf(accountNo));
//                  curr.add(String.valueOf(balance));
//                  data.add(curr);
              }
              
          } catch (SQLException e) {
             System.out.print("Error while fetching customer accounts :"); e.printStackTrace();
          }
      
    	 
    	 return accounts;
     }
     
     
     
     public List<Account> getAllCustomerAccountDetails() {
    	 List<Account> accounts = new ArrayList<>();
    	 
          try {
              String query = "SELECT * FROM account";
              PreparedStatement statement  = connection.prepareStatement(query);
              
              ResultSet rs =  statement.executeQuery();

              while (rs.next()) {
            	  int customerid = rs.getInt("customerid");
                  int accountNo = rs.getInt("accountno");
                  double balance = rs.getDouble("balance");

                  Account curr = new Account();
                  curr.setCustomerId(Integer.toString(customerid));
                  curr.setAccountNo(String.valueOf(accountNo));
                  curr.setBalance(String.valueOf(balance));
                  
//                  List<String> curr = new ArrayList<>();
//                  curr.add(String.valueOf(accountNo));
//                  curr.add(String.valueOf(balance));
//                  data.add(curr);
                  
                  accounts.add(curr);
              }
              
          } catch (SQLException e) {
             System.out.print("Error while fetching all customer accounts :"); e.printStackTrace();
          }
      
    	 
    	 return accounts;
     }
     
     
//     --------------------Transcation---------------------------------------------
     
     public void addTransaction(String customerid, String senderaccno, String receiveraccno, String type, Double amount, String status) {
    	 try {
    		 
    			String transquery = "INSERT INTO transactions (customerid, sender_acc_no, receiver_acc_no, type, amount, date, status) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
    		 
    		 PreparedStatement statement2 = connection.prepareStatement(transquery);
    		  statement2.setInt(1, Integer.parseInt(customerid));
              statement2.setString(2, senderaccno);
              statement2.setString(3, receiveraccno);
              statement2.setString(4, type);
              statement2.setDouble(5, amount);
              
              LocalDate date = LocalDate.now();
              int year = date.getYear();
              int month = date.getMonthValue(); // Get the month (1 to 12)
              int day = date.getDayOfMonth();
              java.sql.Date sqlDate = new java.sql.Date(year - 1900, month - 1, day);

              
              statement2.setDate(6, sqlDate);
              statement2.setString(7, status);
              statement2.executeUpdate();
    		 
    	 }catch(Exception e) {
    		 System.out.println("Adding to transaction error");
    		 e.printStackTrace();
    	 }
     }
     
     public boolean credit(String customerid,String accountno ,String amount) {
    	 
    	 boolean status =  false;
    	 
    	 String query = "SELECT balance FROM account WHERE accountno = ?";
    	    String query2 = "UPDATE account SET balance = ? WHERE accountno = ?";
    	    
    	    
    	    try {
    	        double addAmount = Double.parseDouble(amount);
    	        double currAmount = 0.0;
    	        
    	        PreparedStatement statement = connection.prepareStatement(query);
    	        statement.setInt(1, Integer.parseInt(accountno));
    	        ResultSet rs = statement.executeQuery();
    	        
    	        if (rs.next()) {
    	            currAmount = rs.getDouble("balance");
    	        }
    	        
    	        double newBalance = addAmount + currAmount;
    	        
    	        PreparedStatement statement2 = connection.prepareStatement(query2);
    	        statement2.setDouble(1, newBalance);
    	        statement2.setInt(2, Integer.parseInt(accountno));
    	        statement2.executeUpdate();
    	        
//    	        -------Adding to transactions
    	        
    	        status = true;
    	        addTransaction(customerid, accountno, accountno, "Credit", addAmount, "Success");
    	        
    	        
    	        System.out.println("Money Credited Successfully");
    	    } catch (Exception e) {
    	        System.out.println("Failed to credit");
    	        e.printStackTrace();
    	    }
    	 
      return status;
     }
     
     
     public boolean debit(String customerid,String accountno ,String amount) {
    	 
    	 boolean status = false;
    	 
    	 String query = "SELECT balance FROM account WHERE accountno = ?";
    	    String query2 = "UPDATE account SET balance = ? WHERE accountno = ?";
    	    
    	    try {
    	        double debitAmount = Double.parseDouble(amount);
    	        double currAmount = 0.0;
    	        
    	        PreparedStatement statement = connection.prepareStatement(query);
    	        statement.setInt(1, Integer.parseInt(accountno));
    	        ResultSet rs = statement.executeQuery();
    	        
    	        if (rs.next()) {
    	            currAmount = rs.getDouble("balance");
    	        }
    	        
    	        double newBalance = currAmount-debitAmount ;
    	        if(newBalance<0) {
    	        	 addTransaction(customerid, accountno, accountno, "Debit", debitAmount, "Failed");
    	        	System.out.println("Balance Cannot be Negative");
    	        	return false;
    	        }
    	        
    	        PreparedStatement statement2 = connection.prepareStatement(query2);
    	        statement2.setDouble(1, newBalance);
    	        statement2.setInt(2, Integer.parseInt(accountno));
    	        statement2.executeUpdate();
    	        
    	        status = true;
    	        addTransaction(customerid, accountno, accountno, "Debit", debitAmount, "Success");
    	        
    	        System.out.println("Money Debited Successfully");
    	    } catch (Exception e) {
    	        System.out.println("Failed to Debit");
    	        e.printStackTrace();
    	    }
    	 
      return status;
     }
     
     
     public boolean transfer(String customerid,String accountno ,String amount ,String recaccountno ,String receivercustomerid) {
    	
    	 boolean status = false;
    	 
    	 String getquery = "SELECT balance FROM account WHERE accountno = ?";
    	    String updatequery = "UPDATE account SET balance = ? WHERE accountno = ?";
    	    
    	    try {
    	        double sendAmount = Double.parseDouble(amount);
    	        double sendcurrAmount = 0.0;
    	        double reccurrAmount = 0.0;
    	        
    	        PreparedStatement statement = connection.prepareStatement(getquery);
    	        statement.setInt(1, Integer.parseInt(accountno));
    	        ResultSet rs = statement.executeQuery();
    	        
    	        if (rs.next()) {
    	            sendcurrAmount = rs.getDouble("balance");
    	        }
    	        
    	        double sendernewBalance = sendcurrAmount-sendAmount ;
    	        
    	        if(sendernewBalance<0) {
    	        	 addTransaction(customerid, accountno, recaccountno, "Transfer/Debit", sendAmount, "Failed");
    	        	System.out.println("Balance Cannot be Negative");
    	        	return false;
    	        }
    	        
    	        PreparedStatement statement2 = connection.prepareStatement(updatequery);
    	        statement2.setDouble(1, sendernewBalance);
    	        statement2.setInt(2, Integer.parseInt(accountno));
    	        statement2.executeUpdate();
    	        
//    	        -----------------------------------------------------------------------
    	        PreparedStatement statement3 = connection.prepareStatement(getquery);
    	        statement3.setInt(1, Integer.parseInt(recaccountno));
    	        ResultSet result = statement3.executeQuery();
    	        
    	        if (result.next()) 
    	        	reccurrAmount = result.getDouble("balance");
    	        
    	        double recnewbalance = reccurrAmount + sendAmount;
    	        
    	        PreparedStatement statement4 = connection.prepareStatement(updatequery);
    	        statement4.setDouble(1, recnewbalance);
    	        statement4.setInt(2, Integer.parseInt(recaccountno));
    	        statement4.executeUpdate();
    	        
    	        status = true;
    	        addTransaction(customerid, accountno, recaccountno, "Transfer/Debit", sendAmount, "Success");
    	        addTransaction(receivercustomerid, accountno, recaccountno, "Transfer/Credit", sendAmount, "Success");
    	        
    	        
    	        System.out.println("Money Debited to Receiver Account Successfully");
    	    } catch (Exception e) {
    	        System.out.println("Failed to Debit");
    	        e.printStackTrace();
    	    }
    	 
      return status;
     }
     
     // ---------------------Passbook------------------------------------------
     
     public List<Transaction> getPassbook(String customerid) {
    	 
    	 List<Transaction> passbooks = new ArrayList<>();
    	 
    	 String query = "SELECT * FROM transactions WHERE customerid = ?";
    	 
    	 try {
    		 
    		 PreparedStatement statement = connection.prepareStatement(query);
    		 statement.setInt(1, Integer.parseInt(customerid));
    		 
    		 ResultSet result = statement.executeQuery();
    		 
    		 while(result.next()){
    			 String transid =  Integer.toString(result.getInt("id"));
    			 String cusid = Integer.toString(result.getInt("customerid"));
    			 String senAcc = result.getString("sender_acc_no");
    			 String recAcc = result.getString("receiver_acc_no");
    			 String type = result.getString("type");
    			 String amt = Double.toString(result.getDouble("amount"));
    			 
    	 
    			// DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
    			 
    			 java.sql.Date date1 = (result.getDate("date"));
    			 String date = date1.toString();
    			 String status = result.getString("status");
    			 
    			 Transaction curr = new Transaction();
    			 
//    			 List<String> curr = new ArrayList<>();
    			 
    			 curr.setId(transid);
    			 curr.setCustomerId(cusid);
    			 curr.setSenderAccountNo(senAcc);
    			 curr.setReceiverAccountNo(recAcc);
    			 curr.setType(type);
    			 curr.setAmount(amt);
    			 curr.setDate(date);
    			 curr.setStatus(status);
    			 passbooks.add(curr);
    			 
    			 
    					 
    		 }
    		 
    	 }catch(Exception e) {
    		 System.out.println("Failed to get Passbook");
    		 e.printStackTrace();
    	 }
    	 
    	 return passbooks;
     }
     
  public List<Transaction> getAllPassbook() {
    	 
    	 List<Transaction> passbooks = new ArrayList<>();
    	 
    	 String query = "SELECT * FROM transactions";
    	 
    	 try {
    		 
    		 PreparedStatement statement = connection.prepareStatement(query);
    
    		 
    		 ResultSet result = statement.executeQuery();
    		 
    		 while(result.next()){
    			 String transid =  Integer.toString(result.getInt("id"));
    			 String cusid = Integer.toString(result.getInt("customerid"));
    			 String senAcc = result.getString("sender_acc_no");
    			 String recAcc = result.getString("receiver_acc_no");
    			 String type = result.getString("type");
    			 String amt = Double.toString(result.getDouble("amount"));
    			 
    	 
    			 DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
    			 
    			 String date = dateFormat.format(result.getDate("date"));
    			 String status = result.getString("status");
    			 
    			 
    			 Transaction curr = new Transaction();
    			
    			 curr.setId(transid);
    			 curr.setCustomerId(cusid);
    			 curr.setSenderAccountNo(senAcc);
    			 curr.setReceiverAccountNo(recAcc);
    			 curr.setType(type);
    			 curr.setAmount(amt);
    			 curr.setDate(date);
    			 curr.setStatus(status);
    			 passbooks.add(curr);
    					 
    		 }
    		 
    	 }catch(Exception e) {
    		 System.out.println("Failed to get All Passbook");
    		 e.printStackTrace();
    	 }
    	 
    	 return passbooks;
     }
     
     //----------------------------Edit Customer--------------------------------
  
  public boolean editCustomer(String firstname ,String lastname, String password, String customerid) {
	  
	  boolean status = false;
	  String query = "UPDATE customer SET firstname = ?, lastname = ?, password_ = ? WHERE customerid = ?";
	  
	  try {
		  PreparedStatement statement = connection.prepareStatement(query);
		  statement.setString(1, firstname);
		  statement.setString(2, lastname);
		  statement.setString(3, password);
		  statement.setInt(4, Integer.parseInt(customerid));
		  statement.executeUpdate();
		  

		  status = true;
		  System.out.println("Customer Details Updated Successfully");
	  }catch(Exception e) {
		  System.out.println("Failed to Update Customer Details");
		  e.printStackTrace();
	  }
	  
      return status;
  }
     //-------------------------------------------------------------------------
     
	 
	public static DbConnection getConnection() {
		 if (connection != null) {
			 System.out.println("Connection Already Created");
			 return dbConnection;
         }	else {

    		 dbConnection = new  DbConnection();
    		 return dbConnection;
         }
	}
	
}

