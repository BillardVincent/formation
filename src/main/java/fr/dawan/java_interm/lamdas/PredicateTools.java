package fr.dawan.java_interm.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTools {

	public static <T> String process(T obj, Predicate<T> predicate) {
		if (predicate.test(obj)) {
			return "valid Object";
			
		}
		else {
			return "in valide object";
		}
	}
	
	public static <T> String checkObject(T obj, Predicate<T> predicate) {
		if(predicate.test(obj))
			return "Valid Object";
		else
			return "Wrong object";
	}
	
	public static <T> List<T> filterList(List<T> lst, Predicate<T> filterPredicate){
		List<T> result = new ArrayList<T>();
		for(T obj : lst) {
			if(filterPredicate.test(obj))
				result.add(obj);
		}
		return result;
	}
}
