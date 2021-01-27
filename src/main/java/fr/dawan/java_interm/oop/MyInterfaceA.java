package fr.dawan.java_interm.oop;

public interface MyInterfaceA {
	
	public final static int MY_CONSTANT =3;
	
	void m1();
	
	default void m2() {
		System.out.println("impl par défaut");
	}

}
