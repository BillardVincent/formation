package fr.dawan.java_interm.designPattern.structure.adapter;

public interface XmlAdaptee<T> {

	T fromXML(String filePath, Class<?>...classesToBeBound ) throws Exception;
	String toXML(T obj, Class<?>... classesToBeBound) throws Exception;
}
