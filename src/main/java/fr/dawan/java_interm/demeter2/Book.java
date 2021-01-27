package fr.dawan.java_interm.demeter2;

import java.util.List;

public class Book {

	List <BookArrary> bookArray;
	
	public BookArrary getBookArray(int i) {
		// TODO Auto-generated method stub
		return bookArray.get(i);
	}


	public Country getBookCategory() {
		return getBookArray(0).getCategory();
		
	}

}
