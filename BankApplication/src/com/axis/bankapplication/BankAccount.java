package com.axis.bankapplication;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class BankAccount {

	private String accountNumber;
	private Double minimumBalance;
	private Double currentBalance;
	private Double interestRate;
	private List<Transaction> transactions;

	public void withdraw(Double amount) throws Exception {
		if (this.currentBalance - amount < this.minimumBalance) {
			throw new Exception("Transaction Unsuccessful as amount will become less than the minimum balance");
		}
		Transaction transaction = new Transaction();
//		String uniqueID = UUID.randomUUID().toString();
		String transactionId = transactions.get(transactions.size()).getTransactionId() + 1;
		this.currentBalance -= amount;
		transaction.setTransactionId(transactionId);
		transaction.setAmount(amount);
		transaction.setType("withdraw");
		transactions.add(transaction);
	}

	public void deposit(Double amount) throws Exception {
		if (amount < 0) {
			throw new Exception("Transaction Unsuccessful as amount is negative");
		}
		Transaction transaction = new Transaction();
//		String uniqueID = UUID.randomUUID().toString();
		String transactionId = transactions.get(transactions.size()).getTransactionId() + 1;
		this.currentBalance += amount;
		transaction.setTransactionId(transactionId);
		transaction.setAmount(amount);
		transaction.setType("deposit");
		transactions.add(transaction);
	}

	public List<Transaction> getTransactionHistory() {
		return transactions;
	}

	// returns the last 10 transactions with the latest transaction at the end of
	// the list.
	public List<Transaction> getMiniStatement() {
		List<Transaction> miniStatement = new ArrayList<Transaction>();
		int tenthlast = transactions.size() - 10;
		for (int i = 0; i < 10; i++) {
			miniStatement.add(transactions.get(tenthlast));
			tenthlast++;
		}
		return miniStatement;
	}

	public Double getMinimumBalance() {
		return minimumBalance;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(Double amount) {
		this.currentBalance += amount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public abstract String getType();
}
