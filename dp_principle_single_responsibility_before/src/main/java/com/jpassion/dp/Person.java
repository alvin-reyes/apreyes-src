package com.jpassion.dp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// BAD: The Person class has too much responsibility
// in this case, sending email should not handled
// by Person class
public class Person {

	private String name;
	private String emailAddress;
	private String emailContent;
	
	private static final String EMAIL_PATTERN = "^(.+)@(.+)$";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailContent() {
		return emailContent;
	}
	
	public void setEmailContent(String emailContent) {
		this.emailContent="";
		if (validateEmail(emailContent)){
			this.emailContent = emailContent;
		}
	}
	
	private boolean validateEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	// BAD: this should not be in Person class.
	// If logic of sending email needs to be changed,
	// the Person class needs to be changed.
    public void sendEmail(){
    	System.out.println("sending " + getEmailContent()
    	                   + "to " + getEmailAddress());
    }
	
	@Override
	public String toString(){
		return "name: " + name + " email: " + emailAddress;
	}

}