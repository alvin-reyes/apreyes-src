package com.jpassion.dp;

class Customer {
	
	// BAD: Whenever a new payment scheme needs to be supported,
	// this code (if/else logic below) needs to be modified.  
	public void pay(PaymentScheme paymentScheme) {
		if (paymentScheme.getPaymentSchemeName().equals("cash")){
			((Cash)paymentScheme).pay();
		}
		else if (paymentScheme.getPaymentSchemeName().equals("creditcard")){
			((CreditCard)paymentScheme).pay();
		}
	}


}
