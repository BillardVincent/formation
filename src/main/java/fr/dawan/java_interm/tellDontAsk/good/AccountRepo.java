package fr.dawan.java_interm.tellDontAsk.good;

public interface AccountRepo {

	Account findById(int accountId);

	void save(Account c);

}