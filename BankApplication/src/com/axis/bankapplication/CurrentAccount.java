package com.axis.bankapplication;

public class CurrentAccount extends BankAccount {

	public static final double minimumBalance = 20000;

	public static final double interestRate = 0;

	@Override
	public String getType() {
		return "Current";
	}

}
