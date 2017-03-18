package com.jpassion.dp;

class CreditCard extends PaymentScheme {
	CreditCard() {
		setPaymentSchemeName("creditcard");
	}
	
	public void pay(){
		System.out.println("pay with credit card");
	}
}