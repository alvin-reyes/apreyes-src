package com.jpassion.dp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	private static final String EMAIL_PATTERN = "^(.+)@(.+)$";
	
	public String emailContent;
	
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
	
	@Override
	public String toString(){
		return emailContent;
	}
}