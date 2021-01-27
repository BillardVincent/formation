package fr.dawan.java_interm.tellDontAsk.good;


public class AccountServiceImpl implements AccountService {

	private AccountRepo accRepo;
	
	@Override
	public void withdraw(int accountId, float amount) {
		
		Account c =  accRepo.findById(accountId);
		c.withdraw(amount);
		
		accRepo.save(c);
	}

	
}
// http://demo.dawan.biz/mohamed/Account.java

