package com.axis.bankapplication;

import java.util.List;

public class Customer {

	private String panNumber;
	private List<BankAccount> accounts;

	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public List<BankAccount> getAccounts() {
		return accounts;
	}
	public void addAccount(BankAccount bankAccount) {
		accounts.add(bankAccount);
	}
}
