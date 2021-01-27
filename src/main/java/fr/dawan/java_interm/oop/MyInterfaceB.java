package fr.dawan.java_interm.oop;

public interface MyInterfaceB {
	
	void m3();
	
	default void m2() {
		System.out.println("impl par défaut");
	}

}
