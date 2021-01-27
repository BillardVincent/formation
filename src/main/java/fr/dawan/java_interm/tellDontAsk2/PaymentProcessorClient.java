package fr.dawan.java_interm.tellDontAsk2;

public class PaymentProcessorClient {
	
	private RestClient rest;
    // some code removed for brevity's sake
    public Sale processPayment(Payment payment) throws Exception {
            ResponseEntity response = rest.postForEntity("https://payment.com/payment", payment, Sale.class);
            
            return new Sale(response, payment);
            
}
}