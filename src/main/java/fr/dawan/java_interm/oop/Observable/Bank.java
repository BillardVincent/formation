package fr.dawan.java_interm.oop.Observable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Bank implements Observer{
	
	
	private String name;
	private List<Observable> accounts;
	private int accountNbMax; 
	
	
	public Bank(String name) {
		this.name = name;
	}

	public Account createAccount(String name, double initialAmount) {
		if (accounts==null) accounts = new ArrayList<Observable>();
		Account a = new Account(accountNbMax, name, initialAmount);
		accountNbMax ++;
		a.addObserver(this);
		accounts.add(a);
		return a;
	}
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("change");
		accounts.forEach(a -> {
			
			if (a.equals(o)) {
				a = o ;
				System.out.println("MAJ effectuée : "+ ((Account) a).getClientName() +" - solde : "+ ((Account)a).getBalance() );
			}
		
	});
}
}