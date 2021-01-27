package fr.dawan.java_interm.valueObjects;

public class valueObjects {
	public static void main(String[] args) {
		Geolocalisation g1 = new Geolocalisation(50, 80);
		Geolocalisation g2 = new Geolocalisation(50, 80);
		Geolocalisation g3 = new Geolocalisation(80, 80);
		
		System.out.println("g1 VS g2 : " + g1.equals(g2));
		System.out.println("g2 VS g3 : " + g2.equals(g3));
		System.out.println("g1 VS g3 : " + g1.equals(g3));

		Compagny c1 = new Compagny(0, "La Premiere", g1);
		Compagny c2 = new Compagny(0, "La Seconde", g1);
		Compagny c3 = new Compagny(2, "La Premiere", g2);
		Compagny c4 = new Compagny(3, "La Seconde", g3);
		
		System.out.println("c1 VS c2 : " + c1.equals(c2));
		System.out.println("c1.name VS c2.name : " + c1.compareByName(c2));
		System.out.println("c1 VS c3 : " + c1.equals(c3));
		System.out.println("c1.name VS c3.name : " + c1.compareByName(c3));

		System.out.println("c2 VS c3 : " + c2.equals(c3));
		System.out.println("c2.name VS c3.name : " + c2.compareByName(c3));

		


	}

}
