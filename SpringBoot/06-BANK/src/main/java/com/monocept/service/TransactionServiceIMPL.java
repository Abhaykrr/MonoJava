package com.monocept.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.monocept.entity.Account;
import com.monocept.entity.Transaction;
import com.monocept.entity.TransactionType;
import com.monocept.repository.AccountRepository;
import com.monocept.repository.TransactionRepository;


@Service
public class TransactionServiceIMPL implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private AccountRepository accountRepo;

	@Override
	public void credit(Transaction transaction) {
		
		int accountno = transaction.getAccount().getAccountno();
		
		Account dbAccount = accountRepo.findByAccountno(accountno);
		
		if(dbAccount!=null) {
			
			if(transaction.getTransactiontype().getTypeid()==1) {
				double currBalance = dbAccount.getBalance();
				double toAddAmount = transaction.getAmount();
				dbAccount.setBalance(currBalance + toAddAmount);
				
				
				Transaction newTransation = new Transaction();
				
				newTransation.setAmount(toAddAmount);
				newTransation.setSenderaccountno(accountno);
				newTransation.setReceiveraccountno(accountno);
				newTransation.setStatus("Successfull");
				newTransation.setDate(currDate());
				newTransation.setTransactiontype(transaction.getTransactiontype());
				newTransation.setAccount(dbAccount);
				transactionRepository.save(newTransation);
				

				
			
				System.out.println("Credit of Rs:"+toAddAmount +" to Account:"+accountno +" Successfull");
			}else {
				System.out.println("Wrong type id ");
			}
		}
	}

	@Override
	public void debit(Transaction transaction) {
		int accountno = transaction.getAccount().getAccountno();
		
		Account dbAccount = accountRepo.findByAccountno(accountno);
		
		if(dbAccount!=null) {
			
			if(transaction.getTransactiontype().getTypeid()==2) {
				double currBalance = dbAccount.getBalance();
				double toDebitAmount = transaction.getAmount();

				Transaction newTransation = new Transaction();
				
				if(currBalance-toDebitAmount<0) {
					newTransation.setStatus("Failed");
				}else {

					dbAccount.setBalance(currBalance - toDebitAmount);
					newTransation.setStatus("Successfull");
				}
				
				
				
				
				newTransation.setAmount(toDebitAmount);
				newTransation.setSenderaccountno(accountno);
				newTransation.setReceiveraccountno(accountno);
				newTransation.setDate(currDate());
				newTransation.setTransactiontype(transaction.getTransactiontype());
				newTransation.setAccount(dbAccount);
				transactionRepository.save(newTransation);
				

				
				if(newTransation.getStatus().equals("Failed")) 
					System.out.println("Net Amount Cannot be Negative Debit Failed ");
				else
				    System.out.println("Debit of Rs:"+toDebitAmount +" from Account:"+accountno +" Successfull");
			}else {
				System.out.println("Wrong type id ");
			}
		}else {
			System.out.println("No Account Found for Account No"+accountno);
		}
	}
	
	
	

	@Override
	public void transfer(Transaction transaction) {
		int senderAccountNo = transaction.getSenderaccountno();
		int receiverAccountNo = transaction.getReceiveraccountno();
		Double transferAmount = transaction.getAmount();
		
		Account senderDbAccount = accountRepo.findByAccountno(senderAccountNo);
		Account receiverDbAccount = accountRepo.findByAccountno(receiverAccountNo);
		
		Transaction transactionA = new Transaction();
		
		
		if(senderDbAccount != null && receiverDbAccount !=null) {
			
			if(senderDbAccount.getBalance()<transferAmount) {
				transactionA.setStatus("Failed");
			}else {
				double senderCurrBalance = senderDbAccount.getBalance();
				senderDbAccount.setBalance(senderCurrBalance - transferAmount);
				
				double receiverCurrBalance = receiverDbAccount.getBalance();
				receiverDbAccount.setBalance(receiverCurrBalance + transferAmount);
				
				transactionA.setStatus("Successfull");
			}
			
			transactionA.setAmount(transferAmount);
			transactionA.setDate(currDate());
			transactionA.setSenderaccountno(senderAccountNo);
			transactionA.setReceiveraccountno(receiverAccountNo);
			transactionA.setTransactiontype(transaction.getTransactiontype());
			transactionA.setAccount(senderDbAccount);
			transactionRepository.save(transactionA);
			
			if(transactionA.getStatus().equals("Successfull")) {
				Transaction transactionB = new Transaction();
				
				transactionB.setSenderaccountno(senderAccountNo);
				transactionB.setReceiveraccountno(receiverAccountNo);
				transactionB.setAmount(transferAmount);
				transactionB.setStatus("Successfull");
				transactionB.setDate(currDate());
				transactionB.setTransactiontype(transaction.getTransactiontype());
				transactionB.getTransactiontype().setTypeid(1);
				transactionB.setAccount(receiverDbAccount);
				transactionRepository.save(transactionB);
				
				System.out.println("Money Transfer Successfull From Account :" +senderAccountNo +" To :"+receiverAccountNo +" Of Rs"+transferAmount);
			}else {
				System.out.println("Transfer Failed");
			}
			
		}
		
	}

	public Date currDate() {
		  LocalDate date = LocalDate.now();
        int year = date.getYear();
        int month = date.getMonthValue(); // Get the month (1 to 12)
        int day = date.getDayOfMonth();
        java.sql.Date sqlDate = new java.sql.Date(year - 1900, month - 1, day);
        return sqlDate;
	}

}
