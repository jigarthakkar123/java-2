package com.exception;

public class InSufficientFunds extends Exception{

	double amount;

	public InSufficientFunds(double amount) {
		this.amount = amount;
	}
	public double getAmount() {
		return this.amount;
	}
}
