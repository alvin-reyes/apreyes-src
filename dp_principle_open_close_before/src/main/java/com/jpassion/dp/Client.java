package com.jpassion.dp;

public class Client {
	public static void main(String[] args) {
		Customer customer = new Customer();
		customer.pay(new Cash());
		customer.pay(new CreditCard());
	}

}
