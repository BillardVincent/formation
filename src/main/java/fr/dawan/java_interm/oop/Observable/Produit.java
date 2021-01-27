package fr.dawan.java_interm.oop.Observable;

import java.util.ArrayList;
import java.util.List;

public class Produit implements ISubject<Produit>{
	
	private double price;
	public String description;
	private List<IObserver<Produit>> clients;
	public boolean isModified;
		
	public void setPrice(double price) {
		this.price = price;
		Notify(this);
	}
	public double getPrice() {
		return this.price;
	}
	

	public Produit(double price) {
		this.price = price;
	}
	
	@Override
	public void Attach(IObserver<Produit> o) {
		if (clients == null) clients = new ArrayList();
		clients.add(o);		
	}

	@Override
	public void Dettach(IObserver<Produit> o) {
		clients.remove(o);
		
	}

	@Override
	public void Notify(Produit obj) {
		clients.forEach(c -> c.update(obj));
		
	}

}
