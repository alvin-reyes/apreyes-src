package com.jpassion.dp;

class CreditCard extends PaymentSchemeAbstraction {
	
	CreditCard() {
		setPaymentSchmeName("creditcard");
	}
	
	@Override
	public void pay(){
		System.out.println("pay with credit card");
	}
}