package com.jpassion.dp;

public class Person {

	private String name;
	private Email email;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// GOOD: Email is abstracted into its own class
	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
        this.email = email;
	}

	@Override
	public String toString(){
		return "name: " + name + " email: " + email;
	}

}