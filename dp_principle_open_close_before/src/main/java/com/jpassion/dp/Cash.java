package com.jpassion.dp;

public class Cash extends PaymentScheme {

	Cash() {
		setPaymentSchemeName("cash");
	}
	
	public void pay(){
		System.out.println("pay with cash");
	}
}
