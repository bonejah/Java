package br.com.deitel.cap.three;

public class Account {
	private double balance;
	
	public Account(double initialBalance) {
		if (initialBalance > 0.0)
			this.balance = initialBalance;
	}
	
	public void credit(double amout) {
		this.balance = this.balance + amout;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void debit(double amount) {
		if (amount > this.balance)
			System.out.print("Debit amount exceeded account balance");
		
		if (amount <= this.balance)
			this.balance -= amount;
	}
}
