package fr.dawan.java_interm.designPattern.structure.adapter.correction;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class XmlAdapteeImpl<T> implements XmlAdaptee<T> {

	public String toXml(T obj, Class<?>... classesToBeBound) throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
		Marshaller marshaller = ctx.createMarshaller();
		StringWriter writer = new StringWriter();
		marshaller.marshal(obj, writer);
		String result = writer.toString();
		return result;
	}

}
