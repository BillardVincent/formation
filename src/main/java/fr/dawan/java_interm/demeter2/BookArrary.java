package fr.dawan.java_interm.demeter2;

public class BookArrary {

	private BookHeader bookHeader;
	public BookHeader getBookHeader() {
		// TODO Auto-generated method stub
		return bookHeader;
	}

	public Country getCategory() {
		// TODO Auto-generated method stub
		return bookHeader.getBookCategory();
	}

}
