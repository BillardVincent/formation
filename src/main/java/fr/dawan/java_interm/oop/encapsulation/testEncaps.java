package fr.dawan.java_interm.oop.encapsulation;

public class testEncaps {

	public static void main(String[] args) {
		try {
			Rectangle r = new Rectangle(10L, 6L);
			System.out.println(r.getArea());
			r.changeSize(5L, 25L);
			System.out.println(r.getArea());
			r.changeSize(-50L, 255L);
			System.out.println(r.getArea());

		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
