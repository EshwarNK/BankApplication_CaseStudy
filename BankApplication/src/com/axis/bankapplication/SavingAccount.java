package com.axis.bankapplication;

public class SavingAccount extends BankAccount{

	public static final double minimumBalance = 10000;

	public static final double interestRate = 4.5;

	@Override
	public String getType() {
		return "Saving";
	}
}
