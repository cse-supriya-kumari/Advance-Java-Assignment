package com.userLoginTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.userLogin.UserValidator;

public class UserValidatorTest {

	@Test
	public void testValidUsername() {
		assertTrue(UserValidator.isValidUsername("Supriya"));
	}

	@Test
	public void testPasswordNotNullAlongWithSpecialCharacter() {
		assertTrue(UserValidator.isValidPassword("supriya@123"));
	}

	@Test
	public void testUsernameWithSpecialCharacters() {
		assertFalse(UserValidator.isValidUsername("Supriya@123"));
	}

	@Test
	public void testPasswordNotWithSpecialCahracter() {
		assertFalse(UserValidator.isValidPassword("Supriya"));
	}

	@Test
	public void testShortUsername() {
		assertFalse(UserValidator.isValidUsername("abc"));
	}

	@Test
	public void testShortPassword() {
		assertFalse(UserValidator.isValidPassword("sup@1"));
	}

	@Test
	public void testEmptyUsername() {
		assertFalse(UserValidator.isValidUsername(""));
	}

	@Test
	public void testEmptyPassword() {
		assertFalse(UserValidator.isValidPassword(""));
	}

	@Test
	public void testNullUsername() {
		assertFalse(UserValidator.isValidUsername(null));
	}

	@Test
	public void testNullPassword() {
		assertFalse(UserValidator.isValidPassword(null));
	}

}
