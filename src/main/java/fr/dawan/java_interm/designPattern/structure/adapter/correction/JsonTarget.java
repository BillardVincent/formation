package fr.dawan.java_interm.designPattern.structure.adapter.correction;


public interface JsonTarget<T> {

	String toJSON(T obj, Class<T> clazz) throws Exception;
}
