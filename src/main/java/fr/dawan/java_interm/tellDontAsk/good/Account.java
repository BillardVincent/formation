package fr.dawan.java_interm.tellDontAsk.good;


public class Account {

	private int id;
	private double balance;
	
	public Account(int id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public void withdraw(float amount) {
		if(getBalance()<amount)
			throw new IllegalArgumentException("Error : not enough money !");
		
		setBalance(getBalance()-amount);
	}
	
}