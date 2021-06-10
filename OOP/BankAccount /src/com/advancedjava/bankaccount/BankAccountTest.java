package com.advancedjava.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount katesAccount = new BankAccount();
		System.out.println(katesAccount.getAccountNumber());
		
		System.out.println(katesAccount.deposit(100.00, katesAccount.getAccountNumber(), AccountType.CHEKING));
		System.out.println(katesAccount.withdraw(10.00, katesAccount.getAccountNumber()));
		System.out.println(katesAccount.withdraw(1000.00, katesAccount.getAccountNumber()));
		System.out.println(katesAccount.deposit(1000000.00, katesAccount.getAccountNumber(), AccountType.SAVING));
		
		
		
	
		BankAccount mariasAccount = new BankAccount();
		System.out.println(mariasAccount.deposit(300.00, mariasAccount.getAccountNumber(), AccountType.SAVING));
		System.out.println(mariasAccount.getAccountNumber());
		
		System.out.println(BankAccount.getTotalAmountOfMoneyStored());
		System.out.println(BankAccount.getAllAccounts());
		
		
		
		
		

	}

}
