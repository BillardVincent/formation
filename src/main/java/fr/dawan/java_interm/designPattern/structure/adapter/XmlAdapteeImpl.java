package fr.dawan.java_interm.designPattern.structure.adapter;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlAdapteeImpl<T> implements XmlAdaptee
{

	public static <T extends Serializable> void toXml(T obj, String filePath) throws Exception {
		// try with resources (= Using C#)
		try (XMLEncoder xmlEnc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filePath)))){
			xmlEnc.writeObject(obj);
			xmlEnc.close();
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T fromXml(String filePath) throws Exception{
		Object obj = null;
			try (XMLDecoder xmlDec = new XMLDecoder(new BufferedInputStream(new FileInputStream(filePath)))){
			obj = xmlDec.readObject();
			
		}
			return (T)obj;
	}

	@Override
	public Object fromXML(String filePath, Class... classesToBeBound) throws Exception {
		Object obj = null;
		JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
		        Unmarshaller unmarshaller = ctx.createUnmarshaller();
		        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		        	obj= unmarshaller.unmarshal(reader);
		        }
				return (T)obj;
	}

	@Override
	public String toXML(Object obj, Class... classesToBeBound) throws Exception {
		JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
        Marshaller marshaller = ctx.createMarshaller();
       StringWriter writer = new StringWriter();
       marshaller.marshal(obj, writer);
        String result = writer.toString();
        writer.close();
        return result;
		}
	}


