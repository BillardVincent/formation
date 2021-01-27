package fr.dawan.java_interm.oop.Observable;

import java.util.Observable;

public class Account extends Observable{

	private int accountNb;
	private String clientName;
	private double amount;
	private IObserver<Account> bank;
	
	public Account(int acountNb, String clientName, double initialAmount) {
		this.accountNb = acountNb;
		this.amount = initialAmount;
		this.clientName = clientName;
	}
//	@Override
//	public void Attach(IObserver<Account> o) {
//		bank = o;
//		
//	}
//	@Override
//	public void Dettach(IObserver<Account> o) {
//		bank = null;
//		
//	}
//	@Override
//	public void Notify(Account obj) {
//		if (bank == null) bank.notify();
//		
//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNb;
		result = prime * result + ((clientName == null) ? 0 : clientName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNb != other.accountNb)
			return false;
		if (clientName == null) {
			if (other.clientName != null)
				return false;
		} else if (!clientName.equals(other.clientName))
			return false;
		return true;
	}
	
	public String getClientName() {
		return this.clientName;
	}
	public double getBalance() {
		return this.amount;
	}
	
	public void addMoney(double depot) {
		this.amount+= depot;
		setChanged();
		notifyObservers();
		
	}
	
	
}
