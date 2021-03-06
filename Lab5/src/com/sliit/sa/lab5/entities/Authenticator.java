package com.sliit.sa.lab5.entities;

public class Authenticator implements IAuthenticator {
	private static Authenticator authenticatorInstance = null;
	
	public static Authenticator getInstance() {
		if (authenticatorInstance == null) {
			authenticatorInstance = new Authenticator();
		}
		
		return authenticatorInstance;
	}
	
	public boolean authenticate(User user) {
		return user.getUsername() != null && 
				user.getPassword()!= null &&
				user.getUsername().equals(user.getPassword());
				
	}
}
