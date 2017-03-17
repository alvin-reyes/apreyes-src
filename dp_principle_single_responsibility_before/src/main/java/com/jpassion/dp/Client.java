package com.jpassion.dp;

public class Client {
	
	public static void main(String[] args) {
		
		Person person = new Person();
		person.setName("Alvin");
		person.setEmailAddress("alvin.reyes@botmill.io");
		person.setEmailContent("Hello, BotMill.io!");
		person.sendEmail();
	}

}
