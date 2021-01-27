package fr.dawan.java_interm.oop.Observable;

public class Client implements IObserver<Produit>{
	
	private String name;
	private Produit lastObservedProduit;
	
	private boolean isProductModified;
	
	
	
	public Client(String name) {
		this.name =name;
	}
	
	
	public void ChangeProduct(Produit p) {
		this.lastObservedProduit.Dettach(this);
		p.Attach(this);
	}
	
	public void DeleteProduct(Produit p) {
		this.lastObservedProduit.Dettach(this);
	}



	@Override
	public void update(Produit obj) {
		lastObservedProduit = obj;
		System.out.println(name + " a observé un prix qui a changé : " + lastObservedProduit.getPrice());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}





}
