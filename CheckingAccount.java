package com.exception;

public class CheckingAccount {

	int acno;
	double balance;
	String cname;
	public CheckingAccount(int acno, double balance, String cname) {
		this.acno = acno;
		this.balance = balance;
		this.cname = cname;
		System.out.println("Hello "+cname+", Your Account Number "+acno+" Is Opened With "+balance+" Rs.");
	}
	void deposit(double amount) {
		this.balance+=amount;
	}
	void withdraw(double amount) throws InSufficientFunds{
		if(amount<=this.balance) {
			this.balance-=amount;
		}else {
			throw new InSufficientFunds(amount-this.balance);
		}
	}
	void checkBalance() {
		System.out.println("Current Balance : "+this.balance);
	}
}
