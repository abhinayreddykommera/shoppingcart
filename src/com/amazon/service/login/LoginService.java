package com.amazon.service.login;

public class LoginService {

	public boolean authenticate(String username, String password) {
		if (username != null && username.trim().equalsIgnoreCase("java") && password != null
				&& password.trim().equalsIgnoreCase("java")) {
			return true;
		}

		return false;
	}

}
