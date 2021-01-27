package fr.dawan.java_interm.designPattern.structure.adapter.correction;

public class TestAdapter {

	public static void main(String[] args) {
		JsonTarget<Supplier> target = new XmlJsonAdapter<Supplier>(new XmlAdapteeImpl<Supplier>());
		try {
			String json = target.toJSON(new Supplier(1, "toto"), Supplier.class);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
//
