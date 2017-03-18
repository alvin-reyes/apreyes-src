package com.jpassion.dp;

public class Cash extends PaymentSchemeAbstraction {
	
	Cash() {
		setPaymentSchmeName("cash");
	}
	
	@Override
	public void pay(){
		System.out.println("pay with cash");
	}
	
}
