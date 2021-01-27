package fr.dawan.java_interm.designPattern.structure.adapter.correction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class XmlJsonAdapter<T> implements JsonTarget<T> {

	private XmlAdaptee<T> xmlConverter;
	
	public XmlJsonAdapter(XmlAdaptee<T> xmlConverter) {
		this.xmlConverter = xmlConverter;
	}



	@Override
	public String toJSON(T obj, Class<T> clazz) throws Exception {
		String json = null;
		try {
			String xml = xmlConverter.toXml(obj, Supplier.class, ObjectFactory.class);
			
			XmlMapper xmlMapper = new XmlMapper();
			T objXml = xmlMapper.readValue(xml, clazz);
			ObjectMapper jsonMapper = new ObjectMapper();
			json = jsonMapper.writeValueAsString(objXml);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return json;
	}

}
