package com.advancedjava.bankaccount;
import java.security.SecureRandom;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;
	
	public static int numberOfAccounts = 0;
	public static double totalAmountOfMoneyStored = 0.00;
	
	public BankAccount() {
		this.accountNumber = this.accountNumberCreater();
		numberOfAccounts++;
	}
	
	private String accountNumberCreater() {

		int n = 1000000000 + new SecureRandom().nextInt(1000);
		return String.valueOf(n);
	} 
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getCheckingBalance() {
		return this.checkingBalance;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
	
	public double deposit(Double amount, String accountNum, AccountType acoountType) {
		if(acoountType == AccountType.CHEKING) {
		this.checkingBalance += amount;
		totalAmountOfMoneyStored+=amount;
		return getCheckingBalance();
	}else {
		this.savingsBalance += amount;
		totalAmountOfMoneyStored+=amount;
		return getSavingsBalance();
	}	
}
	

	public double withdraw(Double amount, String accountNum){
		if(getCheckingBalance() - amount >  0) {
			this.checkingBalance -= amount;
			totalAmountOfMoneyStored-=amount;
		}else{
			System.out.println("Account balance doesn't have enough money");	
		}
		return getCheckingBalance();	
	}
	
	public double getTotalAmountOfMoneyStored(String accountNum) {
		return totalAmountOfMoneyStored;
	}
	
	
    public static int getAllAccounts() {
    	return numberOfAccounts;
    }
}
