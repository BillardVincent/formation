package fr.dawan.java_interm.streams;

import java.util.Arrays;
import java.util.List;

import beans.Commande;
import beans.Contact;

public class testStreams {
	public static void main(String[] args) {
		
		
		List <Commande>  lstCo = Arrays.asList(new Commande(new Contact(0,"toto","toto@dawan.fr"), 10.5),
				new Commande(new Contact(0,"toto","toto@dawan.fr"), 44.5),
				new Commande(new Contact(0,"toto","toto@dawan.fr"), 350.8),
				new Commande(new Contact(1,"tata","tata@dawan.fr"), 10.5),
				new Commande(new Contact(2,"bob","bob@dawan.fr"), 210.5),
				new Commande(new Contact(3,"John","john@dawan.fr"), 199.5),
				new Commande(new Contact(4,"clapata","clapata@dawan.fr"), 1050.5),
				new Commande(new Contact(2,"bob","bob@dawan.fr"), 54.5)
				
				);
		
		System.out.println("------- list clients ------");

		lstCo.stream()
		.map(c -> c.getCustomer())
		.distinct()
		.map(co -> co.getName())
		.forEach(System.out::println);
		
		System.out.println("--------  CA --------");

		System.out.println( lstCo.stream()
								.map(c -> c.getAmount())
								.reduce((double) 0, Double::sum)
							);
		
		
		System.out.println("------- commandes > 0 -------");
		lstCo.stream()
		.map(c -> c.getAmount())
		.filter(a -> a>100)
		.forEach(System.out::println);
		
		System.out.println("------- affichage -------");
	
		lstCo.stream()
		.map(c -> c.getCustomer().getName() + " a une commande de: " + c.getAmount() + "€")
		.forEach(System.out::println);
	}
}
