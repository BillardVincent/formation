package beans;

public class Commande {

	private Contact customer;
	
	private double amount;

	public Contact getCustomer() {
		return customer;
	}

	public void setCustomer(Contact customer) {
		this.customer = customer;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Commande(Contact customer, double amount) {
		super();
		this.customer = customer;
		this.amount = amount;
	}

	public Commande() {
		super();
	}
	
	
	
}
