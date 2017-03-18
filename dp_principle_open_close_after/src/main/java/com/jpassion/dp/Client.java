package com.jpassion.dp;

public class Client {

	public static void main(String[] args) {

		// GOOD: payment scheme can be set during runtime.
		// In this example, we simulate runtime setting of
		// payment scheme via command line argument.
		PaymentSchemeAbstraction paymentScheme = null;
		String paymentSchemeName = "com.jpassion.dp.Cash";
		if (args.length == 1) {
			paymentSchemeName = args[0];
		}

		try {
			paymentScheme = (PaymentSchemeAbstraction) Class.forName(paymentSchemeName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// GOOD: Customer class can handle any kind of payment scheme
		// because the payment scheme gets injected during runtime.
		// as an argument of the pay() method.
		Customer customer = new Customer();
		customer.pay(paymentScheme);

	}

}
