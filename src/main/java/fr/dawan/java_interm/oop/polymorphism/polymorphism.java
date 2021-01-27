package fr.dawan.java_interm.oop.polymorphism;

public class polymorphism {

	public static void main(String[] args) {
		
		
		

	}
	//polymorphism ad hoc (à éviter)
	public static void buy(Object obj) {
		if (obj instanceof Pliable) {
			
		}
	}
	
	//polymorphism par sous typage
		public static void buy2(Pliable obj) {
			
		}
		
	//polymorphism par sous typage
		public static <T extends Pliable >void buy3(T obj) {
					
				}

}
