package fr.dawan.java_interm.tellDontAsk2;

public class Sale {

	private ResponseEntity saleResponse;
	
	public Sale(ResponseEntity response, Payment payment) throws Exception {
		this.saleResponse = response;
			if (!saleResponse.isOk()) {
	            logError(getBody());
	            throw new Exception(saleResponse.getStatusCode().toString());
	    }
	    logSuccessfulPayment(payment, getBody());
	}

	private SaleDto getBody() {
		// TODO Auto-generated method stub
		return saleResponse.getBody();
	}

	private void logError(SaleDto body) {
	// TODO Auto-generated method stub

	}

	private void logSuccessfulPayment(Payment payment, SaleDto body) {
	// TODO Auto-generated method stub

	}

	
}
