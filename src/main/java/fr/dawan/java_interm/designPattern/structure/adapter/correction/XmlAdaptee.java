package fr.dawan.java_interm.designPattern.structure.adapter.correction;

public interface XmlAdaptee<T> {

	String toXml(T obj, Class<?>... classesToBeBound) throws Exception;
	
}
