package fr.dawan.java_interm.oop.Observable;

public class Obs {

	public static void main(String[] args) {
		Produit p = new Produit(150.5);
		Client c = new Client("bob");
		Client c2 = new Client("john");

		p.Attach(c);
		p.Attach(c2);
		p.setPrice(250);
		p.Dettach(c);
		p.setPrice(840);
		
		
		
		
		Bank b1 = new Bank("bank1");
		Account a1 = b1.createAccount("bob", 50);
		a1.addMoney(85);
		
		Account a2 = b1.createAccount("Greg", 500);
		a2.addMoney(185);
	}

}
