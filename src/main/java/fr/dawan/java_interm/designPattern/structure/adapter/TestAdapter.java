package fr.dawan.java_interm.designPattern.structure.adapter;

public class TestAdapter {
public static void main(String[] args) {
	JsonTarget<Supplier> target = new XmlJsonAdapter<Supplier>(new XmlAdapteeImpl<Supplier>());
	try {
		String json = target.toJson(new Supplier(1, "toto"));
	} catch (Exception e) {
		// TODO: handle exception
	}
}
}
