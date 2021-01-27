package fr.dawan.java_interm.lamdas;

@FunctionalInterface
public interface Creator<T> {

	T create(String... args);
}