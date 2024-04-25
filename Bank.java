package com.exception;

import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		CheckingAccount c=new CheckingAccount(101, 1000, "Jigar");
		double amount;
		int choice;
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("***************************************");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.println("***************************************");
			System.out.print("Enter Your Choice : ");
			choice=sc.nextInt();
			System.out.println("***************************************");
			if(choice==1)
			{
				System.out.print("Enter Deposit Amount : ");
				amount=sc.nextDouble();
				c.deposit(amount);
				System.out.println("***************************************");
			}
			else if(choice==2)
			{
				System.out.print("Enter Withdrawal Amount : ");
				amount=sc.nextDouble();
				try {
					c.withdraw(amount);
				} catch (InSufficientFunds e) {
					System.out.println("Sorry You Need Another "+e.getAmount()+" Rs.");
				}
				System.out.println("***************************************");
			}
			else if(choice==3)
			{
				c.checkBalance();
			}
			else if(choice==4)
			{
				System.out.println("Thank You For Using Our Services");
				System.out.println("***************************************");
				break;
			}
			else
			{
				System.out.println("Invalid Choice. Please Try Again");
				System.out.println("***************************************");
			}
		}
	}
}
