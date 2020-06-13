package com.axis.bankapplication;

import java.util.List;

public class Branch {

	private List<BankAccount> bankAccounts;
	private List<Customer> customers;
	private String branchId;

	public void createBankAccount(String panNumber, String type, Double amount) {
		BankAccount newAccount = null;
		Customer newCustomer = null;
		boolean isNewCustomer = true;
		String newAccountNumber = null;
		if (type.equals("Saving")) {
			newAccount = new SavingAccount();
		} else if (type.equals("Current")) {
			newAccount = new CurrentAccount();
		}
		newAccount.setCurrentBalance(amount);
		// Since accountNumber is a String, and newAccountNumber must be one greater
		// than the last accountNumber
		if (bankAccounts.size() <= 0) {
			newAccountNumber = "1";
		} else {
			String lastAccountNumber = bankAccounts.get(bankAccounts.size() - 1).getAccountNumber();
			int lastAccount = Integer.parseInt(lastAccountNumber);
			newAccountNumber = Integer.toString(lastAccount + 1);
		}
		for (Customer customer : customers) {
			if (customer.getPanNumber().equals(panNumber)) {
				newAccount.setAccountNumber(newAccountNumber);
				customer.addAccount(newAccount);
				bankAccounts.add(newAccount);
				isNewCustomer = false;
			}
		}
		if (isNewCustomer) {
			newCustomer = new Customer();
			newAccount.setAccountNumber(newAccountNumber);
			newCustomer.addAccount(newAccount);
			customers.add(newCustomer);
			bankAccounts.add(newAccount);
		}
	}

	public Customer getCustomerByPanNumber(String panNumber) throws Exception {
		Customer requestedCustomer = null;
		for (Customer customer : customers) {
			if (customer.getPanNumber().equals(panNumber))
				requestedCustomer = customer;
			else
				throw new Exception("Customer with the given pan number not found");
		}
		return requestedCustomer;
	}

	public BankAccount getAccountByAccountNumber(String accountNumber) throws Exception {
		BankAccount requestedAccount = null;
		for (BankAccount bankAccount : bankAccounts) {
			if (bankAccount.getAccountNumber().equals(accountNumber))
				requestedAccount = bankAccount;
			else
				throw new Exception("Bank Account with the given account number not found");
		}
		return requestedAccount;
	}

	public String getBranchId() {
		return this.branchId;
	}

	public void setBranchId(String branchid) {
		this.branchId = branchid;
	}
}
