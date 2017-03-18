package com.jpassion.dp;

public abstract class PaymentSchemeAbstraction {
	
	private String paymentSchmeName;

	public String getPaymentSchmeName() {
		return paymentSchmeName;
	}

	public void setPaymentSchmeName(String paymentSchmeName) {
		this.paymentSchmeName = paymentSchmeName;
	}

	public abstract void pay();

}