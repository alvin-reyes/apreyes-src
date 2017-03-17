package com.jpassion.dp;

public class Client {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setName("Alvin");
		
		Email email = new Email();
		email.setEmailContent("Hello, BotMill.io!");
		
		// Email is sent via EmailSender class
		EmailSender emailSender = new EmailSender(email, "alvin.reyes@botmill.io");
		emailSender.sendEmail();
		
		
	}
}