package fr.dawan.java_interm.lamdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@FunctionalInterface
public interface MyFunctionalInterface<T,U,R> {
	R doSomething (T p1, U p2);

	public static <T> List<T> filterList(List<T> lst, Predicate<T> filterPredicate){
		List<T> result = new ArrayList<T>();
		for(T obj : lst) {
			if(filterPredicate.test(obj))
				result.add(obj);
		}
		return result;
	}
}
