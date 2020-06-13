package com.axis.bankapplication;

public class Transaction {

	private String transactionId;
	private Double amount;
	private String type;

	public String getTransactionId() {
		return transactionId;
	}
	public Double getAmount() {
		return amount;
	}
	public String getType() {
		return type;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public void setType(String type) {
		this.type = type;
	}

}
