package fr.dawan.java_interm.oop.Observable;

public interface ISubject<T> {

	public void Attach(IObserver<T> o);
	
	public void Dettach(IObserver<T> o);
	
	public void Notify(T obj);
}
