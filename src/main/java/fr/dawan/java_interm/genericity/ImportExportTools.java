package fr.dawan.java_interm.genericity;

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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import beans.Film;

public class ImportExportTools {
	
	public static <T extends Serializable> void toBin(T obj, String filePath) throws Exception {
		// try with resources (= Using C#)
		try (BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filePath))){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T fromBin(String filePath) throws Exception{
		Object obj = null;
			try (BufferedInputStream fos = new BufferedInputStream(new FileInputStream(filePath))){
			ObjectInputStream oos = new ObjectInputStream(fos);
			obj = oos.readObject();
			
		}
			return (T)obj;
	}
	
	
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
	
	public static <T> void toXmlJaxb(T obj, String filePath, Class<?>...classesToBeBound ) throws Exception {
		// try with resources (= Using C#)
		JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
        Marshaller marshaller = ctx.createMarshaller();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                marshaller.marshal(obj, writer);
        }
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T fromXmlJaxb(String filePath, Class<?>...classesToBeBound ) throws Exception {
Object obj = null;
JAXBContext ctx = JAXBContext.newInstance(classesToBeBound);
        Unmarshaller unmarshaller = ctx.createUnmarshaller();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        	obj= unmarshaller.unmarshal(reader);
        }
		return (T)obj;

	}
	
	
	
	

}
