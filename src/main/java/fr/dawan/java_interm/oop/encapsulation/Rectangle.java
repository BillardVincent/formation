package fr.dawan.java_interm.oop.encapsulation;

public class Rectangle {
	private double length;
	private double width;
	
	private void setLength(long length) throws Exception {
		if (length >0) {
			this.length = length;

		}else {
			throw new Exception("la longueur doit etre supéreieures à 0");
		}
	}
	
	private void setWidth(long width) throws Exception {
		if (width >0) {
			this.width = width;

		}else {
			throw new Exception("la largeur doit etre supéreieures à 0");
		}
	}
	
	
	
	public Rectangle (long length, long width) throws Exception {
		changeSize(length,  width);
	}
	
	// __________ methodes métier _________________
	public void changeSize(long length, long width) throws Exception{
		
		setLength(length);
		setWidth(width);
		
	}
	
	public double getArea() {
		return length*width;
	}
	}
