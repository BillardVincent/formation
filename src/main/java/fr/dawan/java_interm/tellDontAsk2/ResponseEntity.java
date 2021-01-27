package fr.dawan.java_interm.tellDontAsk2;

public class ResponseEntity {

	public StatusCode getStatusCode() {
		// TODO Auto-generated method stub
		return null;
	}

	public SaleDto getBody() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isOk() {
			
		return getStatusCode().is2xxSuccessful();
	}

	

}
