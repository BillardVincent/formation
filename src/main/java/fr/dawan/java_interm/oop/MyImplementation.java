package fr.dawan.java_interm.oop;

public class MyImplementation implements MyInterfaceA, MyInterfaceB{

	@Override
	public void m1() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void m3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		MyInterfaceA.super.m2();
	}

}
