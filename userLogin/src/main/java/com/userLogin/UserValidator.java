package com.userLogin;

public class UserValidator {
	public static boolean isValidUsername(String username) {

		if (username == null)
			return false;

		if (username.isEmpty())
			return false;

		if (username.length() < 5 || username.length() > 15)
			return false;

		if (!username.matches("[a-zA-Z0-9]+"))
			return false;

		return true;
	}

	public static boolean isValidPassword(String password) {

		if (password == null)
			return false;

		if (password.isEmpty())
			return false;

		if (password.length() < 8)
			return false;

		if (!password.matches(".*[a-zA-Z].*"))
			return false;

		if (!password.matches(".*[0-9].*"))
			return false;

		if (!password.matches(".*[@$!%*?&].*"))
			return false;

		return true;
	}
	
	
	public static String login(String username, String password) {

		if (!isValidUsername(username)) {
			return "Invalid Username";
		}

		if (!isValidPassword(password)) {
			return "Invalid Password";
		}

		return "Login Successful";
	}
}
