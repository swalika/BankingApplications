package com.threaddemo;

class Bank {
    private double balance;

    public Bank(double initialBalance) {
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit of $" + amount + " successful. New balance: $" + balance);
    }

    public void withdraw(double amount) {
        try {
            if (balance < amount) {
                throw new InsufficientFundsException("Insufficient funds. Withdrawal failed.");
            }

            // If the balance is sufficient, proceed with the withdrawal
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + balance);
        } catch (InsufficientFundsException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }

    public double getBalance() {
        return balance;
    }
}

// Custom exception class for insufficient funds
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


public class BankingApplications {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		        Bank obj = new Bank(1000);
		        obj.deposit(500);
		        obj.withdraw(200);
		        obj.withdraw(800);
		        System.out.println("Final balance: $" + obj.getBalance());
		      
	}

}
