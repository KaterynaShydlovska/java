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
		totalAmountOfMoneyStored += this.checkingBalance + this.savingsBalance;
		
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
	
	public String deposit(Double amount, String accountNum, AccountType acoountType) {
		if(acoountType == AccountType.CHEKING) {
		this.checkingBalance += amount;
		totalAmountOfMoneyStored+=amount;
		return "Checking balance: "+ getCheckingBalance();
	}else {
		this.savingsBalance += amount;
		totalAmountOfMoneyStored+=amount;
		return "Saving balance: " + getSavingsBalance();
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
	
	public static String getTotalAmountOfMoneyStored() {
		return "Total amonut on all accounts: " + totalAmountOfMoneyStored;
	}
	
	
    public static int getAllAccounts() {
    	return numberOfAccounts;
    }
}
