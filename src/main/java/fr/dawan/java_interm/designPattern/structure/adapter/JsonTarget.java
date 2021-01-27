package fr.dawan.java_interm.designPattern.structure.adapter;

public interface JsonTarget<T> {

	String toJson(T obj) throws Exception;
}
