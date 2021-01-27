package fr.dawan.java_interm.lamdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import beans.Contact;

public class LambdasList {

	public static void main(String[] args){
		List<Integer> lst1 = Arrays.asList(2,4,5);
		for (Integer x :lst1) {
			System.out.println(x);
		}
		
		lst1.forEach(x->System.out.println(x));
		
		
		// exemple 2
		lst1.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});
		
		lst1.sort((x1, x2)-> x1-x2);
		
		//exemple3
		
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run() {
				System.out.println("blabla");
			}
		});
		
		Thread t2 = new Thread(()-> {System.out.println("blablabla");});
		
		//________________________________  Lambdas et interfaces fonctionnels _________________________________________
		
		//Consumer : interface fonctionnelle avec une méthode prenant un paramètre et ne retournant aucun résultat
				Consumer<Contact> myConsumer = (c) -> System.out.println(c.getName());
				
				List<Contact> lstCo = Arrays.asList(new Contact(1, "toto", "toto@dawan.fr"),new Contact(2, "titi", "titi@dawan.fr"));
				lstCo.forEach(myConsumer);
				
				myConsumer.accept(lstCo.get(0));
				
				//Function<T,R> : possède un paramètre et retourne un résultat
				Function<Contact, String> myFunction1 = (c)-> c.getId() + "-" + c.getName();
				String resF1 = myFunction1.apply(lstCo.get(0));
				System.out.println(resF1);
				
				//BiFunction<P1,P2, R> : 2 params, 1 retour
				BiFunction<Integer, Integer, Integer> myFunction = (x,y)->x+y;
				System.out.println(myFunction.apply(23, 45));
				
				//Predicate<T> retourne un boolean
				//vérifier si une condition est vérifiée ou pas
				Predicate<Contact> predicate1 = (c)-> c.getEmail().contains("@");
				boolean res = predicate1.test(lstCo.get(0));
				System.out.println(res);
				
				//vérifier que l'objet a un email avec @
				String r1 = PredicateTools.checkObject(lstCo.get(0), predicate1);
				System.out.println(r1);
				
				String r2 = PredicateTools.checkObject(lstCo.get(0), (c)->c.getName().length()>=2);
				System.out.println(r2);
				
				
				List<Contact> contNomA = 
						PredicateTools.filterList(lstCo, (c)->c.getName().charAt(0)=='A');
				
				List<Contact> contEmailDawan = 
						PredicateTools.filterList(lstCo, (c)->c.getEmail().endsWith("@dawan.fr"));
				
				
				MyFunctionalInterface<String, String, Contact> impl =
						(s1,s2)->{return new Contact(0, s1, s2);};
						MyFunctionalInterface<String, String, Contact> impl2 =
								(s1,s2)-> new Contact(0, s1, s2);
											
				Contact resC = impl.doSomething("tata", "tata@dawan.Fr");
				System.out.println(resC);
											
				Creator<Contact> myCreator = (t)->{return new Contact(Integer.parseInt(t[0]),t[1],t[2]);};
				Contact coN = myCreator.create("2","tutu","tutu@dawan.fr");
				System.out.println(coN);
				
	}
}
