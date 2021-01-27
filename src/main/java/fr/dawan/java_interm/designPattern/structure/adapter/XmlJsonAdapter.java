package fr.dawan.java_interm.designPattern.structure.adapter;

public class XmlJsonAdapter<T> implements JsonTarget{

	private XmlAdaptee<T> xmlConverter;
	@Override
	public String toJson(Object obj) throws Exception {
		//String xml = xmlConverter.toXML(obj, Supplier.class, ObjectFactory.class);
		String json = null;
		return json;
	}
	public XmlJsonAdapter(XmlAdaptee<T> xmlConverter) {
		super();
		this.xmlConverter = xmlConverter;
	}

}
