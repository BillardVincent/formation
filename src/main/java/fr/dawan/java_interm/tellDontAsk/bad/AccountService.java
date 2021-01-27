package fr.dawan.java_interm.tellDontAsk.bad;


public class AccountService {

	private AccountRepository accRepo;
	
	public void withdraw(int accountId, float amount) {
		Account c =  accRepo.findById(accountId);
		if(c.getBalance()<amount)
			throw new IllegalArgumentException("Error : not enough money !");
		
		c.setBalance(c.getBalance()-amount);
		
		accRepo.save(c);
	}
}
// http://demo.dawan.biz/mohamed/Account.java

