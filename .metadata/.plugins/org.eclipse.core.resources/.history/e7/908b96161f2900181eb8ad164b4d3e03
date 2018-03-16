package com.sliit.sa.lab5.entities;

public class Authenticator implements IAuthenticator {
	private static Authenticator authenticatorInstance = null;
	
	public static Authenticator getInstance() {
		if (authenticatorInstance == null) {
			authenticatorInstance = new Authenticator();
		}
		
		return authenticatorInstance;
	}
	
	public boolean authenticate(String name, String password) {
		return name != null && password != null && name.equals(password);
	}
}
